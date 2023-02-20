package com.mamaAndPapa.usedCarPapa.service;

import com.mamaAndPapa.usedCarPapa.domain.dto.EUserType;
import com.mamaAndPapa.usedCarPapa.domain.entity.Users;
import com.mamaAndPapa.usedCarPapa.domain.request.UserLoginRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.UserResponse;
import com.mamaAndPapa.usedCarPapa.repository.UsersRepository;
import com.mamaAndPapa.usedCarPapa.security.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;
    private final UserSecurityService userSecurityService;

    public UserResponse loginService(UserLoginRequest request) throws LoginException {
        Optional<Users> findByUserIdAndUserPw =
                usersRepository.findByUserIdAndUserPw(
                        request.getMemberId(),
                        request.getMemberPw()
                );
        Users user =
                findByUserIdAndUserPw
                        .orElseThrow(LoginException::new);
        String token = userSecurityService.createToken(user);
        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getName(),
                user.getUserType(),
                user.getPhoneNumber(),
                user.getLocale(),
                user.getNickName(),
                user.getEmail(),
                token

        );
        return userResponse;
    }

}
