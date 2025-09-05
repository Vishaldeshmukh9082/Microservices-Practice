package com.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userservice.payload.ApiResponce;


// used to handle all exceptions
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResouceNotFoundException.class)
    public ResponseEntity<ApiResponce> handlerResouceNotFoundException(ResouceNotFoundException resouceNotFoundException)
    {
        String message=resouceNotFoundException.getMessage();
        ApiResponce responce=ApiResponce.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();

         return new ResponseEntity<>(responce,HttpStatus.NOT_FOUND);
    }

}
