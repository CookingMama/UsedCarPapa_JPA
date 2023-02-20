package com.mamaAndPapa.usedCarPapa.domain.request;

import com.mamaAndPapa.usedCarPapa.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupRequest {
    @NotEmpty(message = "입력해주세요")
    private String userId;
    @NotEmpty(message = "입력해주세요")
    private String userPw;
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

    public User toEntity() {
        return new User(
                this.userId,
                this.userPw,
                this.name,
                this.phoneNumber,
                this.locale,
                this.nickName,
                this.email
        );
    }

}
