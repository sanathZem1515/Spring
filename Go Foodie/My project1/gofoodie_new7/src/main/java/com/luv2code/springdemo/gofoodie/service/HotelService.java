package com.luv2code.springdemo.gofoodie.service;

import com.luv2code.springdemo.gofoodie.entity.Hotel;

import java.util.List;

public interface HotelService
{
    List<Hotel> findAll();

    void save(Hotel theHotel);

    Hotel saveHotel(Hotel theHotel);

    Hotel findById(int theId);

    Hotel findByHotelName(String hotelName);

    void deleteById(int theId);
}
