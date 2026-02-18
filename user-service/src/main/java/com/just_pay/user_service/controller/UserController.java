package com.just_pay.user_service.controller;

import com.just_pay.user_service.dto.UserRequest;
import com.just_pay.user_service.dto.UserResponse;
import com.just_pay.user_service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserFacade userFacade;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        return userFacade.createUser(userRequest);
    }
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userFacade.getUserById(id);
    }
    @GetMapping
    public List<UserResponse> getAllUser(){
        return userFacade.getAllUser();
    }
}
