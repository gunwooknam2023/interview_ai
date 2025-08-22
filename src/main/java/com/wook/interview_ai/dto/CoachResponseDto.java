package com.wook.interview_ai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * AI가 생성한 코칭 결과(면접 질문, 학습 경로)를 담는 응답 DTO입니다.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoachResponseDto {

    /** AI 생성 예상 면접 질문 목록 */
    private List<String> interviewQuestions;

    /** AI 추천 학습 경로 */
    private List<LearningPathSectionDto> learningPath;
}
