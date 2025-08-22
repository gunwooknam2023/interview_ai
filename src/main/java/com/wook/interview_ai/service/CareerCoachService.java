package com.wook.interview_ai.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.wook.interview_ai.dto.CoachResponseDto;
import com.wook.interview_ai.dto.ResumeRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * AI 커리어 코칭의 핵심 비즈니스 로직을 처리하는 서비스입니다.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CareerCoachService {

    private final Client genaiClient;
    private final ObjectMapper objectMapper;

    @Value("${gemini.prompt}")
    private String promptTemplate;

    public CoachResponseDto generateCoaching(ResumeRequestDto requestDto) {
        // 1. 사용자 이력서 정보를 하나의 텍스트로 결합
        String resumeText = String.format(
                "경력 요약: %s\n수행 직무: %s\n보유 기술: %s",
                requestDto.getCareer(),
                requestDto.getJob(),
                requestDto.getSkill()
        );

        // 2. 프롬프트 템플릿과 이력서 정보를 조합하여 최종 프롬프트 완성
        String finalPrompt = String.format(promptTemplate, resumeText);
        log.info("Gemini AI에게 전송할 최종 프롬프트:\n{}", finalPrompt);

        try {
            /// 3. AI 모델에 요청 전송 및 응답 수신
            GenerateContentResponse response = genaiClient.models.generateContent(
                    "gemini-2.5-flash", // 요청하신 모델 이름으로 변경
                    finalPrompt,
                    null
            );
            String rawResponse = response.text();
            log.info("Gemini AI로부터 받은 원본 응답:\n{}", rawResponse);

            // 4. AI 응답에서 순수 JSON만 추출
            String jsonResponse = extractJson(rawResponse);

            log.info("추출된 순수 JSON 응답:\n{}", jsonResponse);

            // 5. JSON 응답을 DTO 객체로 변환하여 반환
            return objectMapper.readValue(jsonResponse, CoachResponseDto.class);

        } catch (IOException e) {
            log.error("AI 응답 생성 또는 JSON 파싱에 실패했습니다.", e);
            throw new RuntimeException("AI 응답을 처리하는 중 오류가 발생했습니다.");
        }
    }

    /**
     * AI가 생성한 원본 문자열에서 JSON 부분만 추출합니다.
     * (e.g., Markdown 코드 블록 제거)
     * @param rawResponse AI가 보낸 원본 문자열
     * @return 순수 JSON 형식의 문자열
     */
    private String extractJson(String rawResponse) {
        // 첫 '{' 문자의 위치를 찾습니다.
        int startIndex = rawResponse.indexOf('{');
        // 마지막 '}' 문자의 위치를 찾습니다.
        int endIndex = rawResponse.lastIndexOf('}');

        // '{'와 '}'를 모두 찾았고, 순서가 올바르다면 그 사이의 문자열을 반환합니다.
        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            return rawResponse.substring(startIndex, endIndex + 1).trim();
        }

        // JSON 형식을 찾지 못했다면 원본 문자열을 그대로 반환하여 파싱 오류를 유발시킵니다.
        return rawResponse;
    }
}