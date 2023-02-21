package com.mamaAndPapa.usedCarPapa.domain.response;

import com.mamaAndPapa.usedCarPapa.domain.dto.ECarType;
import com.mamaAndPapa.usedCarPapa.domain.dto.EDriveType;
import com.mamaAndPapa.usedCarPapa.domain.dto.EFuel;
import com.mamaAndPapa.usedCarPapa.domain.entity.Manufacturer;
import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @AllArgsConstructor @NoArgsConstructor
@Setter
public class FindOneSellingCarResponse {
    private String seller;
    private String manufacturerName;
    private String modelName;
    private ECarType carType;
    private String detailModelName;
    private String buyDate;
    private String color;
    private EFuel fuel;
    private EDriveType driveType;
    private Integer mileage;
    private Integer price;
    private String location;

    public FindOneSellingCarResponse(SellingCar sellingCar) {
        this.seller = seller;
        this.manufacturerName = sellingCar.getManufacturer().getName();
        this.modelName = sellingCar.getModel().getName();
        this.carType = sellingCar.getDetailModel().getCarType();
        this.detailModelName = sellingCar.getDetailModel().getName();
        this.buyDate = sellingCar.getBuyYear()+""+(sellingCar.getBuyMonth()<10 ? "0"+sellingCar.getBuyMonth() : sellingCar.getBuyMonth());
        this.color = sellingCar.getColor();
        this.fuel = sellingCar.getFuel();
        this.driveType = sellingCar.getDriveType();
        this.mileage = sellingCar.getMileage();
        this.price = sellingCar.getPrice();
        this.location = sellingCar.getLocation();
    }
}
