package com.mamaAndPapa.usedCarPapa.security;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TokenInfo {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String local; //지역
    private String nickName;
    private String email;
    public TokenInfo parseToken(Claims claims) {
        Integer id = (Integer) claims.get("id");
        String name = (String) claims.get("name");
        String phone_number = (String) claims.get("phoneNumber");
        String local = (String) claims.get("local");
        String nick_name = (String) claims.get("nickName");
        String email = (String) claims.get("email");

        return new TokenInfo(id,name,phone_number,local,nick_name,email);
    }
}

