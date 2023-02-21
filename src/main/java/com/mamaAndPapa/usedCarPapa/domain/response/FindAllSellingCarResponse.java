package com.mamaAndPapa.usedCarPapa.domain.response;

import com.mamaAndPapa.usedCarPapa.domain.dto.EUserType;
import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public class FindAllSellingCarResponse {
    private EUserType userType;
    private String detailModel;
    private Integer price;

    public FindAllSellingCarResponse(SellingCar sellingCar) {
        this.userType = EUserType.TYPE_USER;
        this.detailModel = sellingCar.getDetailModel().getName();
        this.price = sellingCar.getPrice();
    }
}
