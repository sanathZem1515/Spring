package com.luv2code.springdemo.gofoodie.controller;

import com.luv2code.springdemo.gofoodie.entity.Hotel;
import com.luv2code.springdemo.gofoodie.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController
{
    @Autowired
    private HotelService hotelService;

    String hotelForm="hotels/hotel-form";
    @GetMapping("/list")
    public String listHotels(Model theModel)
    {
        List<Hotel> theHotels = hotelService.findAll();
        theModel.addAttribute("hotels", theHotels);
        return "hotels/list-hotels";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Hotel theHotel = new Hotel();
        theModel.addAttribute("hotel", theHotel);
        return hotelForm;
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("hotelId") int theId, Model theModel)
    {
        Hotel theHotel = hotelService.findById(theId);
        theModel.addAttribute("hotel", theHotel);
        return hotelForm;
    }

    @PostMapping("/save")
    public String saveHotel(@Valid @ModelAttribute("hotel") Hotel theHotel, BindingResult theBindingResult)
    {
        if(theBindingResult.hasErrors())
        {
            return hotelForm;
        }
        else
        {
           hotelService.save(theHotel);
            return "redirect:/hotels/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("hotelId") int theId)
    {
        hotelService.deleteById(theId);
        return "redirect:/hotels/list";
    }
}
