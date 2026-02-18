package com.just_pay.user_service.service;

import com.just_pay.user_service.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    User getById(Long id);

    List<User> getALlUser();

    User findByEmail(String email);

    boolean existByEmail(String email);

}
