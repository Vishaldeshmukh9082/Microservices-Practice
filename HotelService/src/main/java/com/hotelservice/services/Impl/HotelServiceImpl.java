package com.hotelservice.services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.entities.Hotel;
import com.hotelservice.repositries.HotelRepo;
import com.hotelservice.services.HotelService;

import lombok.RequiredArgsConstructor;

@Service

public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        hotel.setHId(UUID.randomUUID().toString());
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(String hId) {
        
        return hotelRepo.findById(hId).orElseThrow(null);
    }

}
