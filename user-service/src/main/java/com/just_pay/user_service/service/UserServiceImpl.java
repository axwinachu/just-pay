package com.just_pay.user_service.service;

import com.just_pay.user_service.exception.UserIdNotFound;
import com.just_pay.user_service.model.User;
import com.just_pay.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new UserIdNotFound("user id Not found"));
    }
    @Override
    public List<User> getALlUser() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("user email not found"));
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existByEmail(email);
    }
}
