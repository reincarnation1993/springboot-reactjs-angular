package com.springbootexample.services.user;

import com.springbootexample.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> isValidUser(String username, String password);

    List<User> findAll();

    List<User> findById(String identifier);
}