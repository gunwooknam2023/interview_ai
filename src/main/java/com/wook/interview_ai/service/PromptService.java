package com.wook.interview_ai.service;

import com.wook.interview_ai.config.GeminiProperties;
import com.wook.interview_ai.dto.ResumeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * AI 모델에 전달할 프롬프트를 생성하는 책임을 담당하는 서비스입니다.
 */
@Service
@RequiredArgsConstructor
public class PromptService {

    private final GeminiProperties geminiProperties;

    /**
     * 사용자 이력서 정보와 템플릿을 조합하여 최종 프롬프트를 생성합니다.
     * @param requestDto 사용자 이력서 정보
     * @return AI 모델에 전달할 완성된 프롬프트 문자열
     */
    public String createCoachingPrompt(ResumeRequestDto requestDto) {
        // 1. 사용자 이력서 정보를 하나의 텍스트로 결합
        String resumeText = String.format(
                "경력 요약: %s\n수행 직무: %s\n보유 기술: %s",
                requestDto.getCareer(),
                requestDto.getJob(),
                requestDto.getSkill()
        );

        // 2. 프롬프트 템플릿과 이력서 정보를 조합하여 최종 프롬프트 완성
        return String.format(geminiProperties.getPrompt(), resumeText);
    }
}