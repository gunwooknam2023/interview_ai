package com.wook.interview_ai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 학습 경로의 개별 섹션을 나타내는 DTO입니다.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LearningPathSectionDto {

    /** 학습 섹션의 주제 */
    private String sectionTitle;

    /** 세부 학습 주제 목록 */
    private List<String> topics;

    /** 해당 섹션의 학습 목표 */
    private String learningGoal;
}