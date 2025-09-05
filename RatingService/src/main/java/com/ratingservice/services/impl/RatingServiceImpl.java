package com.ratingservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.entities.Rating;
import com.ratingservice.repositories.RatingRepo;
import com.ratingservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

    private final RatingRepo ratingRepo;

    RatingServiceImpl(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String uId) {
        return ratingRepo.findByuId(uId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hId) {
        return ratingRepo.findByhId(hId);
    }



}
