package com.mamaAndPapa.usedCarPapa.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
public class Model {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    private String name;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private List<DetailModel> detailModels = new ArrayList<>();

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private List<SellingCar> sellingCars = new ArrayList<>();

    public Model(Long id) {
        this.id = id;
    }
}
