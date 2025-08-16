package com.wook.interview_ai.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeRequestDto {

    @NotBlank(message = "경력 요약은 필수 입력 항목입니다.")
    private String career;

    @NotBlank(message = "수행 직무는 필수 입력 항목입니다.")
    private String job;

    @NotBlank(message = "보유 기술 스킬은 필수 입력 항목입니다.")
    private String skill;
}
