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

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @Valid 유효성 검사 실패 시 발생하는 예외를 처리합니다.
     *
     * @param e MethodArgumentNotValidException
     * @return 400 Bad Request 응답
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseDto<?> handleValidationExceptions(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder builder = new StringBuilder();

        // 여러 유효성 검사 오류가 있을 경우, 첫 번째 오류에 대한 메시지를 생성합니다.
        if (bindingResult.hasErrors()) {
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
     * 처리되지 않은 나머지 예외들을 처리합니다. (서버 내부 오류)
     *
     * @param e RuntimeException
     * @return 500 Internal Server Error 응답
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponseDto<?> handleRuntimeException(RuntimeException e) {
        log.error("서버 내부 오류 발생: ", e); // 예외의 전체 스택 트레이스를 에러 수준으로 로깅

        return ApiResponseDto.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 내부에 오류가 발생했습니다. 관리자에게 문의해주세요.");
    }
}
