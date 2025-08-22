package com.wook.interview_ai.service;

import com.wook.interview_ai.dto.CoachResponseDto;

/**
 * LLM 서비스의 표준 인터페이스입니다.
 * 모든 LLM 연동 클래스는 이 인터페이스를 구현해야 합니다.
 */
public interface LLMService {
    /**
     * 주어진 프롬프트를 사용하여 LLM으로부터 콘텐츠를 생성합니다.
     * @param prompt AI 모델에 전달할 최종 프롬프트
     * @return AI가 생성한 코칭 결과 DTO
     */
    CoachResponseDto generateContent(String prompt);
}
