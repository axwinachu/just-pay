package com.just_pay.user_service.facade;

import com.just_pay.user_service.dto.UserRequest;
import com.just_pay.user_service.dto.UserResponse;
import com.just_pay.user_service.mapper.UserMapper;
import com.just_pay.user_service.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserServiceImpl userService;
    private final UserMapper userMapper;
    public UserResponse createUser(UserRequest userRequest) {
        return userMapper.userToUserResponse(userService.createUser(userMapper.UserRequestToUser(userRequest)));
    }

    public UserResponse getUserById(Long id) {
        return userMapper.userToUserResponse(userService.getById(id));
    }

    public List<UserResponse> getAllUser() {
        return userService.getALlUser().stream().map(userMapper::userToUserResponse).toList();
    }
}
