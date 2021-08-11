package com.luv2code.springdemo.gofoodie.exceptions.food;

public class FoodNotFoundException extends RuntimeException
{
    public FoodNotFoundException(String message) {
        super(message);
    }

    public FoodNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FoodNotFoundException(Throwable cause) {
        super(cause);
    }
}
