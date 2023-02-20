package com.mamaAndPapa.usedCarPapa.domain.entity;

import com.mamaAndPapa.usedCarPapa.config.BaseEntity;
import com.mamaAndPapa.usedCarPapa.domain.dto.ECarType;
import com.mamaAndPapa.usedCarPapa.domain.dto.EUserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
public class Users extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String userPw;
    @Enumerated(EnumType.STRING)
    private EUserType userType;
    private String name;
    private String phoneNumber;
    private String locale; //지역
    private String nickName;
    private String email;

    public Users(String userId, String userPw, String name, String phoneNumber, String locale, String nickName, String email) {
        this.userId = userId;
        this.userPw = userPw;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.locale = locale;
        this.nickName = nickName;
        this.email = email;
    }

    @OneToMany(mappedBy = "seller",fetch = FetchType.LAZY)
    private List<SellingCar> sellingCars = new ArrayList<>();

    @OneToOne(mappedBy = "dealers", fetch = FetchType.LAZY)
    private DealerInfo dealerInfo;

}
