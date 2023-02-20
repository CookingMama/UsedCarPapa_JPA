package com.mamaAndPapa.usedCarPapa.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DealerSignupRequest {
    @NotEmpty(message = "입력해주세요")
    private String dealerId;
    @NotEmpty(message = "입력해주세요")
    private String dealerPw;
    @NotEmpty(message = "입력해주세요")
    private String name;
    @NotEmpty(message = "입력해주세요")
    private String phoneNumber;
    @NotEmpty(message = "입력해주세요")
    private String locale;
    @NotEmpty(message = "입력해주세요")
    private String nickName;
    @NotEmpty(message = "입력해주세요")
    private String email;
    @NotEmpty(message = "입력해주세요")
    private String companyName;
    @NotEmpty(message = "입력해주세요")
    private String position;
    @NotEmpty(message = "입력해주세요")
    private Long matchCount ;

}
