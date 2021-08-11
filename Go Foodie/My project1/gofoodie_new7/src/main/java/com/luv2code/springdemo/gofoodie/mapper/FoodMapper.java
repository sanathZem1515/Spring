package com.luv2code.springdemo.gofoodie.mapper;

import com.luv2code.springdemo.gofoodie.dto.FoodDto;
import com.luv2code.springdemo.gofoodie.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FoodMapper 
{
    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    //    @Mapping(source = "hotel.id" , target = "theId")
    FoodDto entityToDto(Food theFood);
    Food dtoToEntity(FoodDto theFoodDto);

    List<FoodDto> entitiesToDtos(List<Food> theFoods);
    List<Food> dtosToEntities(List<FoodDto> theFoodDtos);
}
