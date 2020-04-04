package com.springbootexample.repositories.product;

import com.springbootexample.daos.product.ProductDao;
import com.springbootexample.daos.product.ProductRecord;
import com.springbootexample.entities.Product;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("productRepositoryImpl")
public class ProductRepositoryImpl implements ProductRepository<Product, ProductRecord> {

    private ProductDao productDao;
    private ModelMapper modelMapper;

    @Autowired
    public ProductRepositoryImpl(ModelMapper modelMapper, ProductDao productDao) {
        this.modelMapper = modelMapper;
        this.productDao = productDao;
    }

    @PostConstruct
    private void initialize() {
        modelMapper.addConverter(timestampToLocalDateTime());
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll().stream().map(data -> modelMapper.map(data, Product.class)).collect(Collectors.toList());
    }

    @Override
    public List<Product> findById(String identifier) {
        List<Product> productList = new ArrayList<>();
        productDao.findById(Integer.parseInt(identifier)).ifPresent(productRecord -> productList.add(
                modelMapper.map(productRecord, Product.class)
        ));
        return productList;
    }

    @Override
    public AbstractConverter<Timestamp, LocalDateTime> timestampToLocalDateTime() {
        return new AbstractConverter<Timestamp, LocalDateTime>() {
            @Override
            protected LocalDateTime convert(Timestamp source) {
                return source.toLocalDateTime();
            }
        };
    }
}
