package com.wook.interview_ai.service;

import com.wook.interview_ai.config.GeminiProperties;
import com.wook.interview_ai.dto.ResumeRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PromptServiceTest {

    private PromptService promptService;

    @BeforeEach
    void setUp() {
        GeminiProperties properties = new GeminiProperties();
        properties.setPrompt("프롬프트 템플릿: %s");
        promptService = new PromptService(properties);
    }

    @Test
    @DisplayName("이력서 DTO로 최종 프롬프트를 성공적으로 생성한다")
    void createCoachingPrompt_Success() {
        // given - 테스트를 위한 준비 과정
        ResumeRequestDto requestDto = new ResumeRequestDto();
        requestDto.setCareer("경력: 3년차 개발자");
        requestDto.setJob("직무: 백엔드 API 개발");
        requestDto.setSkill("기술: Java, Spring");

        // when - 실제 테스트하려는 메서드를 호출
        String finalPrompt = promptService.createCoachingPrompt(requestDto);

        // then - 호출 결과가 예상과 일치하는지 검증
        assertThat(finalPrompt).contains("프롬프트 템플릿:");
        assertThat(finalPrompt).contains("경력: 3년차 개발자");
        assertThat(finalPrompt).contains("직무: 백엔드 API 개발");
        assertThat(finalPrompt).contains("기술: Java, Spring");
    }
}