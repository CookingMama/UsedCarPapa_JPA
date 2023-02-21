package com.mamaAndPapa.usedCarPapa.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private String sellerName;
    private String buyerName;
    private String content;
    private Integer rating;
    private String sellingCarName;
}
