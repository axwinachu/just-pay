package com.just_pay.user_service.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserIdNotFound.class)
    public Response handleUserIdNotFoundException(Exception ex){
        return new Response(ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Response RemainingExceptions(Exception ex){
        return new Response(ex.getMessage());
    }
}
