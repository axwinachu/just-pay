package com.just_pay.user_service.controller;

import com.just_pay.user_service.dto.LoginRequest;
import com.just_pay.user_service.dto.LoginResponse;
import com.just_pay.user_service.dto.SignupRequest;
import com.just_pay.user_service.dto.UserResponse;
import com.just_pay.user_service.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthFacade authFacade;
    @PostMapping("/signup")
    public UserResponse signup(SignupRequest signupRequest){
        return authFacade.signup(signupRequest);
    }

    @PostMapping("/login")
    public LoginResponse Login(LoginRequest loginRequest){
        return authFacade.login(loginRequest);
    }
}
