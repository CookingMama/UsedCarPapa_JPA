package com.mamaAndPapa.usedCarPapa.domain.entity;

import com.mamaAndPapa.usedCarPapa.config.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Dealer extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String dealerId;
    @Column(nullable = false)
    private String dealerPw;
    private String name;
    private String phoneNumber;
    private String locale; //지역
    private String nickName;
    private String email;
    private String companyName;
    private String position;
    private Integer matchCount;


}
