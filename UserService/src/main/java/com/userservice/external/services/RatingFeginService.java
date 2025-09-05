package com.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.entities.Rating;

@FeignClient(name = "RATINGSERVICE")

public interface RatingFeginService {

    @GetMapping("/rating/user/{uId}")
    public Rating[] getRatings(@PathVariable String uId);

}
