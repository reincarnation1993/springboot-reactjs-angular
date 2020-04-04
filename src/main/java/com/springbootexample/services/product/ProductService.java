package com.springbootexample.services.product;

import com.springbootexample.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
}
