package com.wook.interview_ai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LearningPathSectionDto {

    private String sectionTitle;
    private List<String> topics;
    private String learningGoal;
}
