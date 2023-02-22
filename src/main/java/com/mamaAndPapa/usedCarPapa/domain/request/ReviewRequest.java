package com.mamaAndPapa.usedCarPapa.domain.request;

import com.mamaAndPapa.usedCarPapa.domain.dto.EReviewType;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class ReviewRequest {
    private Long sellingCarId;
    private String content;
    private Integer rating;
    private Long writerId;
    private Long receiverId;
    private EReviewType reviewType;
}
