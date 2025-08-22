package com.wook.interview_ai.exception;

import com.wook.interview_ai.dto.ApiResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 애플리케이션 전역에서 발생하는 예외를 중앙에서 처리하는 클래스입니다.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @Valid 어노테이션을 사용한 유효성 검증 실패 시 발생하는 예외를 처리합니다.
     * @param e MethodArgumentNotValidException
     * @return 400 Bad Request 상태 코드와 에러 메시지를 담은 응답
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseDto<?> handleValidationExceptions(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder builder = new StringBuilder();

        if (bindingResult.hasErrors()) {
            // 여러 에러 중 첫 번째 필드 에러의 메시지를 사용합니다.
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("](은)는 ");
            builder.append(fieldError.getDefaultMessage());
        }

        String errorMessage = builder.toString();
        log.warn("유효성 검사 실패: {}", errorMessage); // 예외 내용을 경고 수준으로 로깅

        return ApiResponseDto.error(HttpStatus.BAD_REQUEST.value(), errorMessage);
    }

    /**
     * 처리되지 않은 모든 런타임 예외(서버 내부 오류)를 처리합니다.
     * @param e RuntimeException
     * @return 500 Internal Server Error 상태 코드와 에러 메시지를 담은 응답
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponseDto<?> handleRuntimeException(RuntimeException e) {
        log.error("서버 내부 오류 발생: ", e);
        return ApiResponseDto.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 내부에 오류가 발생했습니다. 관리자에게 문의해주세요.");
    }
}
