package com.mamaAndPapa.usedCarPapa.controller;


import com.mamaAndPapa.usedCarPapa.domain.request.UserLoginRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.UserResponse;
import com.mamaAndPapa.usedCarPapa.repository.UsersRepository;
import com.mamaAndPapa.usedCarPapa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UsersRepository usersRepository;

    @PostMapping("/login")
    public UserResponse login (@RequestBody @Valid UserLoginRequest request) throws LoginException {
        return userService.loginService(request);
    }
}
