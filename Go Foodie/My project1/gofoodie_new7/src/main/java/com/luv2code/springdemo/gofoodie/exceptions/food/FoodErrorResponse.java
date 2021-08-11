package com.luv2code.springdemo.gofoodie.exceptions.food;

import lombok.Data;

@Data
public class FoodErrorResponse
{
    private String message1;
    private String message2;
    private long timeStamp;


    public FoodErrorResponse(){

    }

    public FoodErrorResponse(String message1, String message2, long timeStamp) {
        this.message1 = message1;
        this.message2 = message2;
        this.timeStamp = timeStamp;
    }
}
