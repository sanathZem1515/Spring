package com.luv2code.springdemo.gofoodie.dao;

import com.luv2code.springdemo.gofoodie.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelJpaRepository extends JpaRepository<Hotel,Integer>
{
    Hotel findByHotelName(String hotelName);
}
