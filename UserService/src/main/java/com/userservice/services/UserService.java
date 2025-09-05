package com.userservice.services;

import java.util.List;

import com.userservice.entities.User;

public interface UserService {


    User saveuser(User user);
    
    User getUserById(String uId);

    List<User> getAllUser();

    void deleteUser(String id);

    User updateUser(User user,String uId);

}
