package com.luv2code.springdemo.gofoodie.dto;

import com.luv2code.springdemo.gofoodie.entity.Hotel;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class FoodDto
{
    private int id;

    @NotNull
    @Size(min=1, message="is required")
    private String itemName;

    @NotNull
    @Min(value = 1,message = "minimum is 1")
    @Max(value=5,message="maximum is 5")
    private float itemRating;

    @NotNull
    private int itemPrice;

    @ToString.Exclude
    private List<Hotel> hotels;


}
