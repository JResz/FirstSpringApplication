package com.example.first_spring.exception;

import com.example.first_spring.exception.custom.EmailAlreadyExistsException;
import com.example.first_spring.exception.custom.EmailNotExistsException;
import com.example.first_spring.exception.custom.UsernameAlreadyExistsException;
import com.example.first_spring.exception.custom.UsernameDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<String> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmailNotExistsException.class)
    public ResponseEntity<String> handleEmailNotExistsException(EmailNotExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(UsernameDoesNotExistException.class)
    public ResponseEntity<String> handleUsernameDoesNotExistsException(UsernameDoesNotExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
    }
}
