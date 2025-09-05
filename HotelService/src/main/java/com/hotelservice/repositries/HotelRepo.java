package com.hotelservice.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelservice.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel,String>{

}
