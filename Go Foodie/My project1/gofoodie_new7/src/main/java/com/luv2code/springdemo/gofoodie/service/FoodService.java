package com.luv2code.springdemo.gofoodie.service;

import com.luv2code.springdemo.gofoodie.dto.FoodDto;
import com.luv2code.springdemo.gofoodie.entity.Food;

import java.util.List;

public interface FoodService
{
    List<Food> findAll();
    List<FoodDto> findAllByHotel();

    List<FoodDto> findAllByHotelName(String hotelName);


    void save(FoodDto theFoodDto);

    FoodDto findById(int theId);

    void deleteById(int theId);


}
