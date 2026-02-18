package com.just_pay.user_service.exception;

public class UserIdNotFound extends RuntimeException {
    public UserIdNotFound(String message) {
        super(message);
    }
}
