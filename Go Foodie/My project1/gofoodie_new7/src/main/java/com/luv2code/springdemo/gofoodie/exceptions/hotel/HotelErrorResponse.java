package com.luv2code.springdemo.gofoodie.exceptions.hotel;

import lombok.Data;

@Data
public class HotelErrorResponse
{
    private int status;
    private String message;
    private long timeStamp;


    public HotelErrorResponse(){

    }

    public HotelErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
