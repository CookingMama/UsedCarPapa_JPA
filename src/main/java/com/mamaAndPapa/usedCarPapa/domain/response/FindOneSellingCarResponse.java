package com.mamaAndPapa.usedCarPapa.domain.response;

import com.mamaAndPapa.usedCarPapa.domain.dto.ECarType;
import com.mamaAndPapa.usedCarPapa.domain.dto.EDriveType;
import com.mamaAndPapa.usedCarPapa.domain.dto.EFuel;
import com.mamaAndPapa.usedCarPapa.domain.entity.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
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
}
