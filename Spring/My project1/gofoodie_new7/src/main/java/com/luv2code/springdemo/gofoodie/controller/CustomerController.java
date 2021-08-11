package com.luv2code.springdemo.gofoodie.controller;

import com.luv2code.springdemo.gofoodie.dto.FoodDto;
import com.luv2code.springdemo.gofoodie.entity.Hotel;
import com.luv2code.springdemo.gofoodie.service.FoodService;
import com.luv2code.springdemo.gofoodie.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    private HotelService hotelService;

    @Autowired
    private FoodService foodService;

    @GetMapping("/")
    public String display(Model theModel)
    {
        List<Hotel> theHotels = hotelService.findAll();
        theModel.addAttribute("hotels", theHotels);
        return "customer/customer-form";
    }

    @GetMapping("/hotel")
    public String displayFoods(@RequestParam String hotelName, Model theModel)
    {

        List<FoodDto> theFoods = foodService.findAllByHotelName(hotelName);

        theModel.addAttribute("foods",theFoods);
        return "customer/items";
    }
}
