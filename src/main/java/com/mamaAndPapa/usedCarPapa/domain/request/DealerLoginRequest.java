package com.mamaAndPapa.usedCarPapa.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DealerLoginRequest {
    @NotEmpty(message = "입력해") // null ""
    private String dealerId;
    @NotEmpty(message = "입력해") // null
    private String dealerPw;
}
