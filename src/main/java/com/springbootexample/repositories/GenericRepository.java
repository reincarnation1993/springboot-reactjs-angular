package com.springbootexample.repositories;

import org.modelmapper.AbstractConverter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface GenericRepository<E, R> {

    List<E> findAll();

    List<E> findById(String identifier);

    AbstractConverter<Timestamp, LocalDateTime> timestampToLocalDateTime();
}
