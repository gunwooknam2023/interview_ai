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

@RestController
@RequestMapping("/api/v1/coach")
@RequiredArgsConstructor
public class CareerCoachController {
    private final CareerCoachService careerCoachService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<CoachResponseDto>> getCoaching(
            @Valid @RequestBody ResumeRequestDto requestDto
    ) {
        CoachResponseDto responseData = careerCoachService.generateCoaching(requestDto);

        // ResponseEntity.ok() 를 사용해 '200 OK' 상태 코드와 함께 응답 본문을 반환
        return ResponseEntity.ok(ApiResponseDto.success(responseData));
    }
}
