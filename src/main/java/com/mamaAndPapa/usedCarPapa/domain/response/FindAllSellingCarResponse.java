package com.mamaAndPapa.usedCarPapa.domain.response;

import com.mamaAndPapa.usedCarPapa.domain.dto.EUserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public class FindAllSellingCarResponse {

    private Long id;
    private String name;
    private Integer price;
    private EUserType userType;
}
