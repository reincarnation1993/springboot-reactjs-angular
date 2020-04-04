package com.springbootexample.services.product;

import com.springbootexample.entities.Product;
import com.springbootexample.repositories.product.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl productRepositoryImpl;

    @Autowired
    public ProductServiceImpl(ProductRepositoryImpl productRepositoryImpl) {
        this.productRepositoryImpl = productRepositoryImpl;
    }

    @Override
    public List<Product> findAll() {
        return productRepositoryImpl.findAll();
    }
}
