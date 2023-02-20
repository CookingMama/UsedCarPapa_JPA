package com.mamaAndPapa.usedCarPapa.domain.response;

import com.mamaAndPapa.usedCarPapa.domain.dto.EUserType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private EUserType userType;
    private String phoneNumber;
    private String locale; //지역
    private String nickName;
    private String email;
    private String token;
}
