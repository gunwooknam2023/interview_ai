package com.wook.interview_ai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * AI 코칭 요청 시 클라이언트로부터 전달받는 이력서 정보 DTO입니다.
 */
@Getter
@Setter
public class ResumeRequestDto {
    /** 경력 요약 */
    @NotBlank(message = "경력 요약은 필수 입력 항목입니다.")
    @Size(max = 1000, message = "경력 요약은 1000자를 초과할 수 없습니다.")
    private String career;

    /** 수행 직무 */
    @NotBlank(message = "수행 직무는 필수 입력 항목입니다.")
    @Size(max = 1000, message = "수행 직무는 1000자를 초과할 수 없습니다.")
    private String job;

    /** 보유 기술 스킬 */
    @NotBlank(message = "보유 기술 스킬은 필수 입력 항목입니다.")
    @Size(max = 500, message = "보유 기술 스킬은 500자를 초과할 수 없습니다.")
    private String skill;
}
