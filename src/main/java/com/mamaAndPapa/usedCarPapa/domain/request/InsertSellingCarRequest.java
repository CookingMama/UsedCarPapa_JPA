package com.mamaAndPapa.usedCarPapa.domain.request;

import com.mamaAndPapa.usedCarPapa.domain.dto.ECheck;
import com.mamaAndPapa.usedCarPapa.domain.dto.EDriveType;
import com.mamaAndPapa.usedCarPapa.domain.dto.EFuel;
import com.mamaAndPapa.usedCarPapa.domain.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter @AllArgsConstructor @NoArgsConstructor
@ToString
public class InsertSellingCarRequest {
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

}
