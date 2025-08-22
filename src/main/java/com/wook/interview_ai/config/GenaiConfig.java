package com.wook.interview_ai.config;

import com.google.genai.Client;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Google Gemini AI와 통신하기 위한 설정을 담당하는 클래스입니다.
 */
@Configuration
public class GenaiConfig {
    @Value("${gemini.api-key}")
    private String apiKey;

    /**
     * Gemini API 클라이언트(Client)를 스프링 빈(Bean)으로 등록합니다.
     * 이 빈은 다른 서비스에서 주입받아 AI 모델과 통신하는 데 사용됩니다.
     */
    @Bean
    @SneakyThrows
    public Client genaiClient() {
        return Client.builder()
                .apiKey(apiKey)
                .build();
    }
}
