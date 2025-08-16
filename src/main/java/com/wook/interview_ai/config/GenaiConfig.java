package com.wook.interview_ai.config;

import com.google.genai.Client;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenaiConfig {
    @Value("${gemini.api-key}")
    private String apiKey;

    @Bean
    @SneakyThrows
    public Client genaiClient() {
        return Client.builder()
                .apiKey(apiKey)
                .build();
    }
}
