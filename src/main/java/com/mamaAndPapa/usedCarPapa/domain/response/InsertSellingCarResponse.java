package com.mamaAndPapa.usedCarPapa.domain.response;

import com.mamaAndPapa.usedCarPapa.domain.dto.EDriveType;
import com.mamaAndPapa.usedCarPapa.domain.dto.EFuel;
import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public class InsertSellingCarResponse {
    private Long sellerId;
    private Long manufacturerId;
    private Long modelId;
    private Long detailModelId;
    private String color;
    private EFuel fuel;
    private EDriveType driveType;
    private Integer mileage;
    private String location;
    private Integer buyYear;
    private Integer buyMonth;
    private Integer price;

    public InsertSellingCarResponse(SellingCar sellingCar) {
        this.sellerId = sellingCar.getSeller().getId();
        this.manufacturerId = sellingCar.getManufacturer().getId();
        this.modelId = sellingCar.getModel().getId();
        this.detailModelId = sellingCar.getDetailModel().getId();
        this.color = sellingCar.getColor();
        this.fuel = sellingCar.getFuel();
        this.driveType = sellingCar.getDriveType();
        this.mileage = sellingCar.getMileage();
        this.location = sellingCar.getLocation();
        this.buyYear = sellingCar.getBuyYear();
        this.buyMonth = sellingCar.getBuyMonth();
        this.price = sellingCar.getPrice();
    }
}
