package com.mamaAndPapa.usedCarPapa.service;

import com.mamaAndPapa.usedCarPapa.domain.entity.Review;
import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import com.mamaAndPapa.usedCarPapa.domain.request.ReviewRequest;
import com.mamaAndPapa.usedCarPapa.repository.ReviewRepository;
import com.mamaAndPapa.usedCarPapa.repository.SellingCarRepository;
import com.mamaAndPapa.usedCarPapa.repository.UsersRepository;
import com.mamaAndPapa.usedCarPapa.security.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final UsersRepository usersRepository;
    private final UserSecurityService securityService;
    private final SellingCarRepository sellingCarRepository;
    private final ReviewRepository reviewRepository;

    public String insertReview(ReviewRequest request) {
        Optional<SellingCar> sellingCarFindById = sellingCarRepository.findById(request.getSellingCarId());
        SellingCar sellingCar = sellingCarFindById.orElseThrow(NullPointerException::new);

        Long myId = securityService.parseToken(securityService.getToken()).getId();
        request.setWriterId(myId);
        if (myId == sellingCar.getSeller().getId()) {
            request.setReceiverId(sellingCar.getBuyerId());
        }
        else {
            request.setReceiverId(sellingCar.getSeller().getId());
        }
        Review review = new Review(request,sellingCar);
        reviewRepository.save(review);

        return "리뷰등록완료";


    }
}
