package com.mamaAndPapa.usedCarPapa.domain.entity;

import com.mamaAndPapa.usedCarPapa.config.BaseEntity;
import com.mamaAndPapa.usedCarPapa.domain.dto.ECarType;
import com.mamaAndPapa.usedCarPapa.domain.dto.ECheck;
import com.mamaAndPapa.usedCarPapa.domain.dto.EDriveType;
import com.mamaAndPapa.usedCarPapa.domain.dto.EFuel;
import com.mamaAndPapa.usedCarPapa.domain.request.InsertSellingCarRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
public class SellingCar{
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

    public SellingCar(InsertSellingCarRequest request) {
        this.seller = new Users(request.getSellerId());
        this.manufacturer = new Manufacturer(request.getManufacturerId());
        this.model = new Model(request.getModelId());
        this.detailModel = new DetailModel(request.getDetailModelId());
        this.color = request.getColor();
        this.fuel = request.getFuel();
        this.driveType = request.getDriveType();
        this.mileage = request.getMileage();
        this.location = request.getLocation();
        this.buyYear = request.getBuyYear();
        this.buyMonth = request.getBuyMonth();
        this.price = request.getPrice();
    }


}
