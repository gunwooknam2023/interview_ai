package com.wook.interview_ai.service;

import com.wook.interview_ai.dto.CoachResponseDto;
import com.wook.interview_ai.dto.ResumeRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CareerCoachServiceTest {

    @Mock
    private LLMService llmService;

    @Mock
    private PromptService promptService;

    @InjectMocks
    private CareerCoachService careerCoachService;

    @Test
    @DisplayName("코칭 요청 시, 각 서비스를 호출하여 성공적으로 결과를 반환한다")
    void generateCoaching_Success() {
        // given - 가짜 객체들이 어떻게 동작할지 미리 정의합니다.
        String fakePrompt = "생성된 가짜 프롬프트";
        CoachResponseDto fakeResponse = new CoachResponseDto(List.of("면접 질문1"), List.of());

        // promptService의 createCoachingPrompt 메서드가 호출되면, fakePrompt를 반환하도록 설정
        when(promptService.createCoachingPrompt(any(ResumeRequestDto.class)))
                .thenReturn(fakePrompt);

        // llmService의 generateContent 메서드가 fakePrompt와 함께 호출되면, fakeResponse를 반환하도록 설정
        when(llmService.generateContent(fakePrompt))
                .thenReturn(fakeResponse);

        // when - 실제 테스트하려는 메서드를 호출
        CoachResponseDto result = careerCoachService.generateCoaching(new ResumeRequestDto());

        // then - 반환된 결과가 우리가 정의한 가짜 응답과 일치하는지 검증
        assertThat(result).isNotNull();
        assertThat(result.getInterviewQuestions().get(0)).isEqualTo("면접 질문1");
    }
}