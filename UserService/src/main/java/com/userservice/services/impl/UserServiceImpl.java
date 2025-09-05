package com.userservice.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import com.userservice.entities.User;
import com.userservice.exceptions.ResouceNotFoundException;
import com.userservice.external.services.HotelFeginService;
import com.userservice.external.services.RatingFeginService;
import com.userservice.repo.UserRepositry;
import com.userservice.services.UserService;

import jakarta.ws.rs.HttpMethod;


@Service
public class UserServiceImpl implements UserService {

    private UserRepositry userRepositry;

    //For Communcation using RestTemplete 
    private RestTemplate restTemplate;

    //For Communcation using Fegin
    private HotelFeginService hotelFeginService;
    private RatingFeginService ratingFeginService;

    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepositry userRepositry, RestTemplate restTemplate,HotelFeginService hotelFeginService,RatingFeginService ratingFeginService) {
        this.userRepositry = userRepositry;
        this.restTemplate = restTemplate;
        this.hotelFeginService = hotelFeginService;
        this.ratingFeginService=ratingFeginService;

    }

    @Override
    public User saveuser(User user) {
        String randomId=UUID.randomUUID().toString();
        user.setUId(randomId);
        return userRepositry.save(user);
    }

    @Override
    public User getUserById(String uId) {
        User user= userRepositry.findById(uId)
                .orElseThrow(() -> new ResouceNotFoundException("User Not Found with given Id: " + uId));


        // link for commumcation with rating service
        //http://localhost:8083/rating/user/b74d4747-5dbd-43bd-8801-120c10c591b2    

        //commumcation using RestTemplete
        // Rating[] ratingsArray = restTemplate.getForObject(
        //         "http://RATINGSERVICE/rating/user/" + user.getUId(),
        //         Rating[].class
        // );

        //Communciation Declarative Feign 
        Rating[] ratingsArray=ratingFeginService.getRatings(user.getUId());

        List<Rating> userRatingsList = Arrays.asList(ratingsArray);
        List<Rating> newlist=userRatingsList.stream().map(rating->{

        //commumcation using RestTemplete
            // ResponseEntity<Hotel> hotelreponse=restTemplate.getForEntity("http://HOTELSERVICE/hotel/" + rating.getHId(), Hotel.class);
            // Hotel hotel=hotelreponse.getBody();

        //Communciation Declarative Feign 
            Hotel hotel=hotelFeginService.getHotel(rating.getHId());


            rating.setHotel(hotel);
            return rating;
            
        }).collect(Collectors.toList());

        user.setRatings(newlist);
        
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepositry.findAll();
    }

    @Override
    public void deleteUser(String uId) {
        User user = getUserById(uId); // ensures user exists, else throws exception
        userRepositry.delete(user);
    }

    @Override
    public User updateUser(User user, String uId) {
        return userRepositry.findById(uId)
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    return userRepositry.save(existingUser);
                })
                .orElseThrow(() -> new ResouceNotFoundException("User Not Found with given Id: " + uId));
    }
}