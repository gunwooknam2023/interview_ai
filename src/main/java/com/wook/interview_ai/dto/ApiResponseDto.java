package com.wook.interview_ai.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ApiResponseDto<T> {
    private final Integer statusCode;
    private final String message;
    private final T data;

    /**
     * API 성공 응답을 생성합니다.
     * @param data 실제 응답 데이터
     * @return ApiResponseDto 객체
     * @param <T> 데이터의 타입
     */
    public static <T> ApiResponseDto<T> success(T data) {
        return new ApiResponseDto<>(HttpStatus.OK.value(), "요청에 성공했습니다.", data);
    }

    /**
     * API 실패 응답을 생성합니다.
     * @param statusCode HTTP 상태 코드
     * @param message 응답 메시지
     * @return ApiResponseDto 객체
     * @param <T> 데이터의 타입 (보통 Void 또는 null)
     */
    public static <T> ApiResponseDto<T> error(Integer statusCode, String message) {
        return new ApiResponseDto<>(statusCode, message, null);
    }
}
