package com.mamaAndPapa.usedCarPapa.domain.response;

import com.mamaAndPapa.usedCarPapa.domain.dto.EUserType;
import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import com.mamaAndPapa.usedCarPapa.security.TokenInfo;
import com.mamaAndPapa.usedCarPapa.security.UserSecurityService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public class FindAllSellingCarResponse {
    private UserSecurityService userSecurityService;
    private EUserType userType;
    private String detailModel;
    private Integer price;

    public FindAllSellingCarResponse(SellingCar sellingCar) {
        this.userType = userSecurityService.parseToken(userSecurityService.getToken()).getUserType();
        this.detailModel = sellingCar.getDetailModel().getName();
        this.price = sellingCar.getPrice();
    }
}
