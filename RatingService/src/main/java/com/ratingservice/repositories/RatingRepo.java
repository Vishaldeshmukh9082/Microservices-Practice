package com.ratingservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ratingservice.entities.Rating;

@Repository
public interface RatingRepo extends MongoRepository<Rating,String> {

    List<Rating> findByuId(String uId);
    List<Rating> findByhId(String hId);
}
