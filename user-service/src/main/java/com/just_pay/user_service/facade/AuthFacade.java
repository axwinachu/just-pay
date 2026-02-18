package com.just_pay.user_service.facade;

import com.just_pay.user_service.dto.LoginRequest;
import com.just_pay.user_service.dto.LoginResponse;
import com.just_pay.user_service.dto.SignupRequest;
import com.just_pay.user_service.dto.UserResponse;
import com.just_pay.user_service.enums.Role;
import com.just_pay.user_service.mapper.UserMapper;
import com.just_pay.user_service.model.User;
import com.just_pay.user_service.service.UserServiceImpl;
import com.just_pay.user_service.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacade {
    private final UserServiceImpl userService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;
    public UserResponse signup(SignupRequest signupRequest) {
        if(userService.existByEmail(signupRequest.getEmail())){
            throw new RuntimeException("Email already registered");
        }
        User newUser=User.builder()
                .name(signupRequest.getUserName())
                .email(signupRequest.getEmail())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .role(Role.ROLE_USER).build();
        userService.createUser(newUser);
        return userMapper.userToUserResponse(newUser);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        User user=userService.findByEmail(loginRequest.getEmail());
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }
        return new LoginResponse(jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole().name()));
    }
}
