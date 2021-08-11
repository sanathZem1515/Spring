package com.luv2code.springdemo.gofoodie.mapper;

import com.luv2code.springdemo.gofoodie.dto.HotelDto;
import com.luv2code.springdemo.gofoodie.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelMapper
{
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    HotelDto entityToDto(Hotel theHotel);
    Hotel dtoToEntity(HotelDto theHotelDto);

    List<HotelDto> entitiesToDtos(List<Hotel> theHotels);
    List<Hotel> dtosToEntities(List<HotelDto> theHotelDtos);

}
