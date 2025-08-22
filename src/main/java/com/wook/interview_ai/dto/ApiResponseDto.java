package com.wook.interview_ai.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * API의 모든 응답을 위한 표준 형식 클래스입니다.
 * @param <T> 응답 데이터의 타입
 */
@Getter
@RequiredArgsConstructor
public class ApiResponseDto<T> {
    /** HTTP 상태 코드 */
    private final Integer statusCode;

    /** 응답 메시지 */
    private final String message;

    /** 실제 응답 데이터 */
    private final T data;

    /** 성공 응답 생성 */
    public static <T> ApiResponseDto<T> success(T data) {
        return new ApiResponseDto<>(HttpStatus.OK.value(), "요청에 성공했습니다.", data);
    }

    /** 실패 응답 생성 */
    public static <T> ApiResponseDto<T> error(Integer statusCode, String message) {
        return new ApiResponseDto<>(statusCode, message, null);
    }
}
