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
 * 커리어 코칭 비즈니스 로직의 전체 흐름을 제어(오케스트레이션)하는 서비스입니다.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CareerCoachService {

    private final PromptService promptService;
    private final GeminiService geminiService;

    public CoachResponseDto generateCoaching(ResumeRequestDto requestDto) {
        // 1. PromptService를 통해 AI에게 보낼 프롬프트를 생성합니다.
        String finalPrompt = promptService.createCoachingPrompt(requestDto);
        log.info("Gemini AI에게 전송할 최종 프롬프트:\n{}", finalPrompt);

        // 2. GeminiService를 통해 AI 응답을 받아옵니다.
        return geminiService.generateCoaching(finalPrompt);
    }
}