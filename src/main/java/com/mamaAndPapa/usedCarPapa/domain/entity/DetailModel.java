package com.mamaAndPapa.usedCarPapa.domain.entity;

import com.mamaAndPapa.usedCarPapa.domain.dto.ECarType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
public class DetailModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;
    private String name;
    @Enumerated(EnumType.STRING)
    private ECarType carType;

    @OneToMany(mappedBy = "detailModel", fetch = FetchType.LAZY)
    private List<SellingCar> sellingCars = new ArrayList<>();
}
