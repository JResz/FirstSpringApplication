package com.example.first_spring.exception.custom;

public class UsernameDoesNotExistException extends RuntimeException {
    public UsernameDoesNotExistException(String message) {
        super(message);
    }
}
