package com.wook.interview_ai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 추천 학습 자료(설명 + URL)를 나타내는 DTO입니다.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendedResourceDto {

    /** 자료에 대한 간략한 설명 */
    private String description;

    /** 자료로 연결되는 전체 URL */
    private String url;
}