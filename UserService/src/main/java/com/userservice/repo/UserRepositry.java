package com.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entities.User;

public interface UserRepositry extends JpaRepository<User,String> {

}
