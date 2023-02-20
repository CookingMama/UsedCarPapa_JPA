package com.mamaAndPapa.usedCarPapa.domain.entity;

import com.mamaAndPapa.usedCarPapa.config.BaseEntity;
import com.mamaAndPapa.usedCarPapa.domain.dto.ECarType;
import com.mamaAndPapa.usedCarPapa.domain.dto.ECheck;
import com.mamaAndPapa.usedCarPapa.domain.dto.EDriveType;
import com.mamaAndPapa.usedCarPapa.domain.dto.EFuel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
public class SellingCar extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Users seller;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_model_id")
    private DetailModel detailModel;
    private String color;
    @Enumerated(EnumType.STRING)
    private EFuel fuel;
    @Enumerated(EnumType.STRING)
    private EDriveType driveType;
    private Integer mileage;
    private String location;
    private Integer buyYear;
    private Integer buyMonth;
    private Integer price;
    private Long buyerId;
    @Enumerated(EnumType.STRING)
    private ECheck buyCheck;
}
