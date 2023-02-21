package com.mamaAndPapa.usedCarPapa.controller;

import com.mamaAndPapa.usedCarPapa.domain.request.ReviewRequest;
import com.mamaAndPapa.usedCarPapa.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @PostMapping
    public String writeReview(@RequestBody ReviewRequest request) {
        return reviewService.insertReview(request);
    }
}
