package com.springbootexample.daos;

import java.util.List;

public interface GenericDao<R> {
    List<R> findById(String identifier);

    List<R> findAll();

    String create(R record);

    R update(R record);

    long count();

    void deleteById(String identifier);

    void delete(R record);

    boolean existsById(String identifier);
}
