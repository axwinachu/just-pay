package com.just_pay.user_service.mapper;

import com.just_pay.user_service.dto.UserRequest;
import com.just_pay.user_service.dto.UserResponse;
import com.just_pay.user_service.enums.Role;
import com.just_pay.user_service.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User UserRequestToUser(UserRequest userRequest){
       return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .role(Role.ROLE_USER)
                .password(userRequest.getPassword()).build();
    }
    public UserResponse userToUserResponse(User user){
        return UserResponse.builder()
                .Id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
