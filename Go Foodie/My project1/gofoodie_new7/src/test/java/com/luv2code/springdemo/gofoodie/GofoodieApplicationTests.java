package com.luv2code.springdemo.gofoodie;

import com.luv2code.springdemo.gofoodie.dao.FoodJpaRepository;
import com.luv2code.springdemo.gofoodie.dao.HotelJpaRepository;
import com.luv2code.springdemo.gofoodie.entity.Food;
import com.luv2code.springdemo.gofoodie.entity.Hotel;
import com.luv2code.springdemo.gofoodie.mapper.FoodMapper;
import com.luv2code.springdemo.gofoodie.service.FoodService;
import com.luv2code.springdemo.gofoodie.service.FoodServiceImpl;
import com.luv2code.springdemo.gofoodie.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={com.luv2code.springdemo.gofoodie.GofoodieApplication.class})
class GofoodieApplicationTests
{


	@Test
	void contextLoads() {
	}

	private FoodService foodService;

	@Mock
	private FoodJpaRepository mockRepository;


	@BeforeEach
	void initUseCase(){
		foodService = new FoodServiceImpl(mockRepository);
	}

	@Test
	void findByIdMocked()
	{
		Food food = new Food("Chocolate",3,3);
		when(mockRepository.findById(1)).thenReturn(java.util.Optional.of(food));
		assertEquals(food, FoodMapper.INSTANCE.dtoToEntity(foodService.findById(1)));
		Mockito.verify(mockRepository).findById(1);
	}

	@Test
	void getFood()
	{
		when(mockRepository.findAll()).thenReturn(Stream.of(new Food("Chocolate",3,3),new Food("Chocolate",3,3)).collect(Collectors.toList()));
		assertEquals(2,foodService.findAll().size());
	}
}
