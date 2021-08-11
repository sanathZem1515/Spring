package com.luv2code.springdemo.rest;

import lombok.Data;

@Data
public class StudenterrorResponse
{
    private int status;
    private String message;
    private long timeStamp;


    public StudenterrorResponse(){

    }

    public StudenterrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
