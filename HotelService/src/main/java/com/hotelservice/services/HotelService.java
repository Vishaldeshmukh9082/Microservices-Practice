package com.hotelservice.services;

import java.util.List;

import com.hotelservice.entities.Hotel;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(String hId);

}
