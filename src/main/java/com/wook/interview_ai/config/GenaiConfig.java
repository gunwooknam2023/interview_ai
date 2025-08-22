package com.wook.interview_ai.config;

import com.google.genai.Client;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Google Gemini AI와 통신하기 위한 설정을 담당하는 클래스입니다.
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(GeminiProperties.class)
public class GenaiConfig {
    private final GeminiProperties geminiProperties;

    /**
     * Gemini API 클라이언트(Client)를 스프링 빈(Bean)으로 등록합니다.
     */
    @Bean
    @SneakyThrows
    public Client genaiClient() {
        return Client.builder()
                .apiKey(geminiProperties.getApiKey())
                .build();
    }
}
