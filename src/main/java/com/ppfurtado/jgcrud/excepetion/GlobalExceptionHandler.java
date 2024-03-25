package com.ppfurtado.jgcrud.excepetion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroDatails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {

        ErroDatails erroDatails = new ErroDatails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "USER_NOT_FOUND"
        );

        return new ResponseEntity<>(erroDatails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErroDatails> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception, WebRequest request){

        ErroDatails erroDatails = new ErroDatails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "USER_EMAIL_ALREADY_EXISTS"
        );

        return new ResponseEntity<>(erroDatails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroDatails> handleGlobalException(Exception exception, WebRequest request){

        ErroDatails erroDatails = new ErroDatails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false),
                "INTERNAL_SERVER_ERROR"
        );

        return new ResponseEntity<>(erroDatails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
