package com.wook.interview_ai.controller;

import com.wook.interview_ai.dto.ApiResponseDto;
import com.wook.interview_ai.dto.CoachResponseDto;
import com.wook.interview_ai.dto.ResumeRequestDto;
import com.wook.interview_ai.service.CareerCoachService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AI 커리어 코칭 API의 엔드포인트를 정의하는 컨트롤러입니다.
 */
@RestController
@RequestMapping("/api/v1/coach")
@RequiredArgsConstructor
public class CareerCoachController {
    private final CareerCoachService careerCoachService;

    /**
     * 사용자 이력서 정보를 받아 AI 코칭 결과를 반환합니다.
     * @param requestDto @Valid를 통해 유효성이 검증된 이력서 정보
     * @return AI 코칭 결과가 담긴 ResponseEntity 객체
     */
    @PostMapping
    public ResponseEntity<ApiResponseDto<CoachResponseDto>> getCoaching(
            @Valid @RequestBody ResumeRequestDto requestDto
    ) {
        CoachResponseDto responseData = careerCoachService.generateCoaching(requestDto);
        return ResponseEntity.ok(ApiResponseDto.success(responseData));
    }
}
