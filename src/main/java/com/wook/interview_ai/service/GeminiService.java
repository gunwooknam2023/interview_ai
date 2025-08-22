package com.wook.interview_ai.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.wook.interview_ai.dto.CoachResponseDto;
import com.wook.interview_ai.exception.LLMProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Gemini AI 모델과의 통신 및 응답 처리를 전담하는 서비스입니다.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GeminiService {

    private final Client genaiClient;
    private final ObjectMapper objectMapper;

    /**
     * 완성된 프롬프트를 AI 모델에 전달하고, 응답을 DTO로 파싱하여 반환합니다.
     * @param finalPrompt AI 모델에 전달할 최종 프롬프트
     * @return AI가 생성한 코칭 결과 DTO
     */
    public CoachResponseDto generateCoaching(String finalPrompt) {
        try {
            // 1. AI 모델에 요청 전송 및 응답 수신
            GenerateContentResponse response = genaiClient.models.generateContent(
                    "gemini-2.5-flash-lite", // 사용할 모델 이름
                    finalPrompt,
                    null
            );
            String rawResponse = response.text();
            log.info("Gemini AI로부터 받은 원본 응답:\n{}", rawResponse);

            // 2. AI 응답에서 순수 JSON만 추출
            String jsonResponse = extractJson(rawResponse);
            log.info("추출된 순수 JSON 응답:\n{}", jsonResponse);

            // 3. JSON 응답을 DTO 객체로 변환하여 반환
            return objectMapper.readValue(jsonResponse, CoachResponseDto.class);

        } catch (IOException e) {
            log.error("AI 응답 생성 또는 JSON 파싱에 실패했습니다.", e);
            throw new LLMProcessingException("AI 응답을 처리하는 중 오류가 발생했습니다.", e);
        }
    }

    /**
     * AI가 생성한 원본 문자열에서 JSON 부분만 추출합니다.
     * @param rawResponse AI가 보낸 원본 문자열
     * @return 순수 JSON 형식의 문자열
     */
    private String extractJson(String rawResponse) {
        int startIndex = rawResponse.indexOf('{');
        int endIndex = rawResponse.lastIndexOf('}');

        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            return rawResponse.substring(startIndex, endIndex + 1).trim();
        }
        return rawResponse;
    }
}
