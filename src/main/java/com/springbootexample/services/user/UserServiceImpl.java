package com.springbootexample.services.user;

import com.springbootexample.entities.User;
import com.springbootexample.repositories.user.UserRepositoryImpl;
import com.springbootexample.utils.BCryptPasswordUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    private UserRepositoryImpl userRepositoryImpl;

    private BCryptPasswordUtil bCryptPasswordUtil;

    @Autowired
    public UserServiceImpl(UserRepositoryImpl userRepositoryImpl, BCryptPasswordUtil bCryptPasswordUtil) {
        this.userRepositoryImpl = userRepositoryImpl;
        this.bCryptPasswordUtil = bCryptPasswordUtil;
    }

    @Override
    public Optional<User> isValidUser(String username, String password) {
        List<User> users = userRepositoryImpl.findByUserName(username);
        if (CollectionUtils.isNotEmpty(users)
                && bCryptPasswordUtil.checkBCryptPassword(password, users.get(0).getPassword())) {
            return Optional.of(users.get(0));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        return userRepositoryImpl.findAll();
    }

    @Override
    public List<User> findById(String identifier) {
        return userRepositoryImpl.findById(identifier);
    }

}
