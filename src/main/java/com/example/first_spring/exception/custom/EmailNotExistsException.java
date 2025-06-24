package com.example.first_spring.exception.custom;

public class EmailNotExistsException extends RuntimeException {
    public EmailNotExistsException(String message) {
        super(message);
    }
}
