package com.ratingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.entities.Rating;
import com.ratingservice.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/user/{uId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String uId){
        return ResponseEntity.ok(ratingService.getRatingsByUserId(uId));
    }
    @GetMapping("/hotel/{hId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hId ){
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hId));
    }
}
