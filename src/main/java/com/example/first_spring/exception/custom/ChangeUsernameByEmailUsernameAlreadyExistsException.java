package com.example.first_spring.exception.custom;

public class ChangeUsernameByEmailUsernameAlreadyExistsException extends RuntimeException {

    public ChangeUsernameByEmailUsernameAlreadyExistsException(String message) {
        super(message);
    }
}
