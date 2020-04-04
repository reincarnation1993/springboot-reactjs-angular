package com.springbootexample.repositories.user;

import com.springbootexample.entities.User;
import com.springbootexample.repositories.GenericRepository;

import java.util.List;

public interface UserRepository<E, R> extends GenericRepository<E, R> {
    List<User> findByUserName(String userName);
}
