package com.luv2code.springdemo.gofoodie.controller;

import com.luv2code.springdemo.gofoodie.dto.FoodDto;
import com.luv2code.springdemo.gofoodie.entity.User;
import com.luv2code.springdemo.gofoodie.service.FoodService;
import com.luv2code.springdemo.gofoodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController
{
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    String foodForm="food/food-form";

    @GetMapping("/list")
    public String listFoods(Model theModel)
    {
        List<FoodDto> theFoods = foodService.findAllByHotel();
        theModel.addAttribute("foods", theFoods);
        return "food/list-food";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        FoodDto theFood = new FoodDto();
        theFood.setId(0);
        theModel.addAttribute("food", theFood);
        return foodForm;
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("itemId") int theId, Model theModel)
    {
        FoodDto theFood = foodService.findById(theId);
        theModel.addAttribute("food", theFood);
        return foodForm;
    }

    @PostMapping("/save")
    public String saveFood(@Valid @ModelAttribute("food") FoodDto theFood, BindingResult theBindingResult)
    {
        if(theBindingResult.hasErrors())
        {
            return foodForm;
        }
        else
        {
           foodService.save(theFood);
            return "redirect:/food/list";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int theId)
    {
        foodService.deleteById(theId);
        return "redirect:/food/list";
    }

    @GetMapping("/change-password")
    public String passwordHandler(Model theModel)
    {
        theModel.addAttribute("user",new User());
        return "food/change-password";
    }

    @PostMapping("/savePassword")
    public String changePassword(@Valid @ModelAttribute("user") User user, BindingResult theBindingResult)
    {
        if(theBindingResult.hasErrors())
        {
            return "food/change-password";
        }
        else
        {
            userService.save(user);
            return "redirect:/";
        }

    }

}
