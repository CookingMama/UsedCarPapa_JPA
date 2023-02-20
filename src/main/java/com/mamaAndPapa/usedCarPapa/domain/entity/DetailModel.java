package com.mamaAndPapa.usedCarPapa.domain.entity;

import com.mamaAndPapa.usedCarPapa.domain.dto.ECarType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
public class DetailModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model modelId;
    private String name;
    @Enumerated(EnumType.STRING)
    private ECarType carType;
}
