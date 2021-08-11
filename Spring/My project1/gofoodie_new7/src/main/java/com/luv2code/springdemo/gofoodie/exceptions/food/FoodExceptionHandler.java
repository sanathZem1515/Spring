package com.luv2code.springdemo.gofoodie.exceptions.food;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FoodExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<FoodErrorResponse> handleException(FoodNotFoundException exc)
    {
        FoodErrorResponse error = new FoodErrorResponse();

        error.setMessage1("We will be available soon ");
        error.setMessage2(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<FoodErrorResponse> handleException(Exception exc)
    {
        FoodErrorResponse error = new FoodErrorResponse();

        error.setMessage1("We will be available soon ");
        error.setMessage2(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
