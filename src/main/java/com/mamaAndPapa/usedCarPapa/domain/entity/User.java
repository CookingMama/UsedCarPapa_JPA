package com.mamaAndPapa.usedCarPapa.domain.entity;

import com.mamaAndPapa.usedCarPapa.config.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String userPw;
    private String name;
    private String phoneNumber;
    private String locale; //지역
    private String nickName;
    private String email;

    public User(String userId, String userPw, String name, String phoneNumber, String locale, String nickName, String email) {
        this.userId = userId;
        this.userPw = userPw;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.locale = locale;
        this.nickName = nickName;
        this.email = email;
    }
}
