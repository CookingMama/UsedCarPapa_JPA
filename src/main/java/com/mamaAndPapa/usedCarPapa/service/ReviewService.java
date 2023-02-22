package com.mamaAndPapa.usedCarPapa.service;

import com.mamaAndPapa.usedCarPapa.domain.dto.EReviewType;
import com.mamaAndPapa.usedCarPapa.domain.entity.Review;
import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import com.mamaAndPapa.usedCarPapa.domain.entity.Users;
import com.mamaAndPapa.usedCarPapa.domain.request.ReviewRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.AboutMeReviewResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.AboutSomeoneReviewResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.FindAllSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.repository.ReviewRepository;
import com.mamaAndPapa.usedCarPapa.repository.SellingCarRepository;
import com.mamaAndPapa.usedCarPapa.repository.UsersRepository;
import com.mamaAndPapa.usedCarPapa.security.TokenInfo;
import com.mamaAndPapa.usedCarPapa.security.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import javax.el.CompositeELResolver;
import java.util.ArrayList;
import java.util.List;
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
            request.setReviewType(EReviewType.SELL);

        } else if (myId == sellingCar.getBuyerId()) {
            request.setReceiverId(sellingCar.getSeller().getId());
            request.setReviewType(EReviewType.BUY);
        } else {
            return "권한이없습니다";
        }
        Review review = new Review(request, sellingCar);
        reviewRepository.save(review);

        return "리뷰등록완료";
    }

    public List<AboutMeReviewResponse> viewReviewsIWrote(Pageable pageable) {
        List<AboutMeReviewResponse> findAllWrittenReviewByMe = new ArrayList<>();
        Page<Review> all = reviewRepository.findAllByOrderByCreateAt(pageable);
        TokenInfo my = securityService.parseToken(securityService.getToken());
        for (Review one : all) {

            if (my.getId() == one.getWriterId()) {
                Optional<Users> targetUser = usersRepository.findById(one.getReceiverId());
                Users target = targetUser.orElseThrow(() -> new NullPointerException("not found target user"));
                findAllWrittenReviewByMe.add(
                        new AboutMeReviewResponse(
                                my.getName(),
                                target.getName(),
                                one.getContent(),
                                one.getRating(),
                                one.getSellingCar().getDetailModel().getName(),
                                one.getReviewType()
                        )
                );
            }
        }

        return findAllWrittenReviewByMe;
    }
    public List<AboutMeReviewResponse> viewReviewsIReceived(Pageable pageable) {
        List<AboutMeReviewResponse> findAllReceivedReviewAboutMe = new ArrayList<>();
        Page<Review> all = reviewRepository.findAllByOrderByCreateAt(pageable);
        TokenInfo my = securityService.parseToken(securityService.getToken());
        for (Review one : all) {

            if (my.getId() == one.getReceiverId()) {
                Optional<Users> targetUser = usersRepository.findById(one.getWriterId());
                Users target = targetUser.orElseThrow(() -> new NullPointerException("not found target user"));
                findAllReceivedReviewAboutMe.add(
                        new AboutMeReviewResponse(
                                my.getName(),
                                target.getName(),
                                one.getContent(),
                                one.getRating(),
                                one.getSellingCar().getDetailModel().getName(),
                                one.getReviewType()
                        )
                );
            }
        }
        return findAllReceivedReviewAboutMe;
    }

    public List<AboutSomeoneReviewResponse> viewReviewsSomeoneReceived(Pageable pageable , Long id) {
        List<AboutSomeoneReviewResponse> findAllReceivedReviewAboutSomeone = new ArrayList<>();
        Page<Review> all = reviewRepository.findAllByOrderByCreateAt(pageable);
        for (Review one : all) {
            Optional<Users> targetUser = usersRepository.findById(id);
            Users target = targetUser.orElseThrow(() -> new NullPointerException("not found target user"));
            if (id == one.getReceiverId()) {

                findAllReceivedReviewAboutSomeone.add(
                        new AboutSomeoneReviewResponse(
                                target.getName(),
                                one.getContent(),
                                one.getRating(),
                                one.getSellingCar().getDetailModel().getName(),
                                one.getReviewType()
                        )
                );
            }
        }
        return findAllReceivedReviewAboutSomeone;


    }
}
