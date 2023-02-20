package com.mamaAndPapa.usedCarPapa.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    @NotEmpty(message = "입력해주세요")
    private String memberId;

    @NotEmpty(message = "입력해주세요")
    private String memberPw;

}
