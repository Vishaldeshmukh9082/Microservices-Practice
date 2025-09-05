package com.ratingservice.services;

import java.util.List;

import com.ratingservice.entities.Rating;

public interface RatingService {

    Rating saveRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingsByUserId(String uId);

    List<Rating> getRatingsByHotelId(String hId);
    
}
