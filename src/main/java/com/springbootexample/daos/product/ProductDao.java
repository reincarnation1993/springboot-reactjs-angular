package com.springbootexample.daos.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public interface ProductDao extends JpaRepository<ProductRecord, Integer> {
}
