package com.mamaAndPapa.usedCarPapa.controller;

import com.mamaAndPapa.usedCarPapa.domain.dto.EReviewType;
import com.mamaAndPapa.usedCarPapa.domain.request.ReviewRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.AboutMeReviewResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.AboutSomeoneReviewResponse;
import com.mamaAndPapa.usedCarPapa.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @PostMapping
    public String writeReview(@RequestBody ReviewRequest request) {
        return reviewService.insertReview(request);
    }
    @GetMapping("/my/iwrote")
    public List<AboutMeReviewResponse> showReviewIWrote( Pageable pageable) {
        return reviewService.viewReviewsIWrote(pageable);
    }
    @GetMapping("/my/ireceive")
    public List<AboutMeReviewResponse> showReviewIReceived( Pageable pageable) {
        return reviewService.viewReviewsIReceived(pageable);
    }
    @GetMapping("/my")
    public List<AboutMeReviewResponse> showReviewAboutMe( Pageable pageable) {
        List<AboutMeReviewResponse> a = new ArrayList<>();
        a.addAll(reviewService.viewReviewsIReceived(pageable));
        a.addAll(reviewService.viewReviewsIWrote(pageable));
        return a;
    }
    @GetMapping("/{id}")
    public List<AboutSomeoneReviewResponse> showReviewTargetReceive(@PathVariable Long id, Pageable pageable) {
        return reviewService.viewReviewsSomeoneReceived(pageable, id);
    }
    @GetMapping("/{id}/{reviewType}")
    public List<AboutSomeoneReviewResponse> showReviewTargetReceive(
            @PathVariable Long id,
            Pageable pageable,
            @PathVariable EReviewType reviewType) throws Exception {
        List<AboutSomeoneReviewResponse> aList = new ArrayList<>();

        for (AboutSomeoneReviewResponse a : reviewService.viewReviewsSomeoneReceived(pageable, id) ) {
            if (a.getReviewType() == reviewType ) {
                aList.add(a);
            }
        }

        return aList;
    }
}
