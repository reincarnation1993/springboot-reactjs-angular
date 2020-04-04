package com.springbootexample.daos.user;

import com.springbootexample.daos.GenericDao;

import java.util.List;

interface UserDao<R> extends GenericDao<R> {
    List<UserRecord> findByUserName(String userName);
}
