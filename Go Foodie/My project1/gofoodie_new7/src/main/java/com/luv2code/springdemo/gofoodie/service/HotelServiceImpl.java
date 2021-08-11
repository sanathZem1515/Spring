package com.luv2code.springdemo.gofoodie.service;

import com.luv2code.springdemo.gofoodie.dao.AuthoritiesJpaRepository;
import com.luv2code.springdemo.gofoodie.dao.FoodJpaRepository;
import com.luv2code.springdemo.gofoodie.dao.HotelJpaRepository;
import com.luv2code.springdemo.gofoodie.dao.UserJpaRepository;
import com.luv2code.springdemo.gofoodie.entity.Authorities;
import com.luv2code.springdemo.gofoodie.entity.Hotel;
import com.luv2code.springdemo.gofoodie.entity.User;
import com.luv2code.springdemo.gofoodie.exceptions.hotel.HotelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService
{

    @Autowired
    private HotelJpaRepository hotelJpaRepository;

    @Autowired
    private AuthoritiesJpaRepository authoritiesJpaRepository;

    @Autowired
    public HotelServiceImpl(HotelJpaRepository mockRepository) {
        hotelJpaRepository=mockRepository;
    }

    @Override
    public List<Hotel> findAll() {
        return hotelJpaRepository.findAll();
    }

    @Override
    public void save(Hotel theHotel) {
        String password = "{noop}"+theHotel.getPassword();
        User theUser = new User(theHotel.getHotelName(),password,1);

        Authorities authorities = new Authorities("ROLE_HOTEL",theUser);
        if(authoritiesJpaRepository.findAllByUser(theUser)==null)
            authoritiesJpaRepository.save(authorities);

        Hotel tempHotel=hotelJpaRepository.findByHotelName(theHotel.getHotelName());
        if(tempHotel!=null && check(tempHotel,theHotel))
        {
                return;
        }
        hotelJpaRepository.save(theHotel);
    }

    @Override
    public Hotel saveHotel(Hotel theHotel) {
        hotelJpaRepository.save(theHotel);
        return theHotel;
    }

    @Override
    public Hotel findById(int theId) {
        Optional<Hotel> result =  hotelJpaRepository.findById(theId);

        Hotel theHotel = null;
        if(result.isPresent())
        {
            theHotel = result.get();
        }
        else{
            throw new RuntimeException("Did not find hotel id "+theId);
        }

        return theHotel;
    }

    @Override
    public Hotel findByHotelName(String hotelName) {
        Hotel hotel = hotelJpaRepository.findByHotelName(hotelName);

        if(hotel==null)
            throw new HotelNotFoundException("Hotel name not found "+ hotelName);

        return hotel;
    }

    @Override
    public void deleteById(int theId) {
            hotelJpaRepository.deleteById(theId);
    }

    public boolean check(Hotel hotel1,Hotel hotel2)
    {
        if(hotel1.getHotelAddress().equals(hotel2.getHotelAddress()) && hotel1.getHotelRating()==hotel2.getHotelRating() && hotel1.getPhoneNum().equals(hotel2.getPhoneNum()))
        {
            return true;
        }
        return false;
    }
}
