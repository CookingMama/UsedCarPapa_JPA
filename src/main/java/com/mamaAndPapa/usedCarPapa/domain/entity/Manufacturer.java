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
public class Manufacturer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private List<Model> models = new ArrayList<>();

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private List<SellingCar> sellingCars = new ArrayList<>();
}
