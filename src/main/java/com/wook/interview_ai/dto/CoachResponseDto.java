package com.wook.interview_ai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoachResponseDto {

    private List<String> interviewQuestions;
    private String learningPath;
}
