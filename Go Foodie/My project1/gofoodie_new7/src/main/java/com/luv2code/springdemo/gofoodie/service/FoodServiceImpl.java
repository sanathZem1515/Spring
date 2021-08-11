package com.luv2code.springdemo.gofoodie.service;

import com.luv2code.springdemo.gofoodie.dao.FoodJpaRepository;
import com.luv2code.springdemo.gofoodie.dao.HotelJpaRepository;
import com.luv2code.springdemo.gofoodie.dto.FoodDto;
import com.luv2code.springdemo.gofoodie.entity.Food;
import com.luv2code.springdemo.gofoodie.entity.Hotel;
import com.luv2code.springdemo.gofoodie.exceptions.food.FoodNotFoundException;
import com.luv2code.springdemo.gofoodie.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService
{
    @Autowired
    private FoodJpaRepository foodJpaRepository;

    @Autowired
    private HotelJpaRepository hotelJpaRepository;

    @Autowired
    public FoodServiceImpl(FoodJpaRepository mockRepository) {
        foodJpaRepository=mockRepository;
    }

    public String getUserName()
    {
        String currentUserName=null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }

        return  currentUserName;
    }

    @Override
    public List<Food> findAll() {
        return foodJpaRepository.findAll();
    }

    @Override
    public List<FoodDto> findAllByHotel()
    {
       String currentUserName = getUserName();

        Hotel tempHotel = hotelJpaRepository.findByHotelName(currentUserName);
        return FoodMapper.INSTANCE.entitiesToDtos(tempHotel.getItems());
    }

    @Override
    public List<FoodDto> findAllByHotelName(String hotelName)
    {
        Hotel tempHotel = hotelJpaRepository.findByHotelName(hotelName);
        List<FoodDto> theFoods = FoodMapper.INSTANCE.entitiesToDtos(tempHotel.getItems());
        if(theFoods.isEmpty())
            throw new FoodNotFoundException("No Food found! ");
        return theFoods;
    }

    @Override
    public void save(FoodDto theFoodDto)
    {
        String currentUserName=getUserName();

        Hotel tempHotel = hotelJpaRepository.findByHotelName(currentUserName);
        Food theFood = FoodMapper.INSTANCE.dtoToEntity(theFoodDto);


        if(theFood.getId()==0) {
            List<Food> hotelFoods = tempHotel.getItems();
            for (Food hotelFood : hotelFoods) {
                if (hotelFood.getItemName().equals(theFood.getItemName())) {
                    return;
                }
            }
        }

        if (tempHotel != null)
        {
            theFood.addHotel(tempHotel);
            foodJpaRepository.save(theFood);
        }
    }

    @Override
    public FoodDto findById(int theId) {
        Optional<Food> result =  foodJpaRepository.findById(theId);
        Food theFood = null;
        if(result.isPresent())
        {
            theFood = result.get();
        }
        else{
            throw new RuntimeException("Did not find food id "+theId);
        }
        return FoodMapper.INSTANCE.entityToDto(theFood);
    }

    @Override
    public void deleteById(int theId) {
            foodJpaRepository.deleteById(theId);
    }
}
