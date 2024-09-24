package com.springApaLearning.monster_trainer.Exception;


import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, UserNotFoundException.class})

    public ResponseEntity<ApiError> exceptionHandler(EntityNotFoundException e, HttpServletRequest request){
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)

    public ResponseEntity<ApiError> exceptionHandler(SQLException e, HttpServletRequest request){
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)

    public ResponseEntity<ApiError> exceptionHandler(Exception e, HttpServletRequest request){
        ApiError apiError = new ApiError(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }



}
