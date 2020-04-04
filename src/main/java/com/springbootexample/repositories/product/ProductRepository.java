package com.springbootexample.repositories.product;

import com.springbootexample.repositories.GenericRepository;

import java.util.List;

public interface ProductRepository<E, R> extends GenericRepository<E, R> {
    List<E> findAll();
}
