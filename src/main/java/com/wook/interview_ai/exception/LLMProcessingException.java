package com.wook.interview_ai.exception;

/**
 * LLM 처리 과정에서 발생하는 오류를 위한 커스텀 예외입니다.
 */
public class LLMProcessingException extends RuntimeException {

    public LLMProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
