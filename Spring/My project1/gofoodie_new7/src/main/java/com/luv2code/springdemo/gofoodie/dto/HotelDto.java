package com.luv2code.springdemo.gofoodie.dto;

import com.luv2code.springdemo.gofoodie.entity.Food;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class HotelDto
{
    private int hotelId;

    @NotNull
    @Size(min=1, message="is required")
    private String hotelName;

    @NotNull
    @Size(min=1, message="is required")
    private String hotelAddress;

    @NotNull
    @Pattern(regexp = "^[6-9]\\d{9}$",message = "phone number is not valid")
    private String phoneNum;

    @NotNull
    @Min(value = 1,message = "minimum is 1")
    @Max(value=5,message="maximum is 5")
    private float hotelRating;

    @NotNull(message="is required")
    private float priceFactor;

    @ToString.Exclude
    private List<Food> items;

}
