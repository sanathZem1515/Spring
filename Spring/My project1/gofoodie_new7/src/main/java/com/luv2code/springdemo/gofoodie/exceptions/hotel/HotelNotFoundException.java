package com.luv2code.springdemo.gofoodie.exceptions.hotel;

public class HotelNotFoundException extends RuntimeException
{
    public HotelNotFoundException(String message) {
        super(message);
    }

    public HotelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HotelNotFoundException(Throwable cause) {
        super(cause);
    }
}
