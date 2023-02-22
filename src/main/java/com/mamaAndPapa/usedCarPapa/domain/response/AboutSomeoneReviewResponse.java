package com.mamaAndPapa.usedCarPapa.domain.response;

import com.mamaAndPapa.usedCarPapa.domain.dto.EReviewType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AboutSomeoneReviewResponse {
    private String targetName;
    private String content;
    private Integer rating;
    private String sellingCarName;
    private EReviewType reviewType;



}
