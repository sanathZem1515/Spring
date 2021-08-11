package com.luv2code.springdemo.gofoodie.dao;

import com.luv2code.springdemo.gofoodie.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodJpaRepository extends JpaRepository<Food,Integer>
{
        Food findByItemName(String itemName);
}
