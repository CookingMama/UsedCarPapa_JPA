package com.mamaAndPapa.usedCarPapa.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mamaAndPapa.usedCarPapa.config.BaseEntity;
import com.mamaAndPapa.usedCarPapa.domain.dto.EReviewType;
import com.mamaAndPapa.usedCarPapa.domain.request.ReviewRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "selling_car_id")
    private SellingCar sellingCar;
    private String content;
    private Integer rating;

    private Long writerId;
    private Long receiverId;
    @Enumerated(EnumType.STRING)
    private EReviewType reviewType;

    public Review(ReviewRequest request, SellingCar sellingCar) {
        this.sellingCar = sellingCar;
        this.content = request.getContent();
        this.rating = request.getRating();
        this.writerId = request.getWriterId();
        this.receiverId = request.getReceiverId();
        this.reviewType = request.getReviewType();

    }
}
