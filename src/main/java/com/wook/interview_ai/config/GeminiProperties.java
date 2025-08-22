package com.wook.interview_ai.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * application.yml의 'gemini' 하위 설정 값들을 객체로 바인딩하는 클래스입니다.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "gemini")
public class GeminiProperties {
    /** Gemini API 키 */
    private String apiKey;

    /** AI 모델에 전달할 프롬프트 템플릿 */
    private String prompt;
}
