package com.springbootexample.repositories.user;

import com.springbootexample.daos.user.UserDaoImpl;
import com.springbootexample.daos.user.UserRecord;
import com.springbootexample.entities.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository("userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository<User, UserRecord> {

    private ModelMapper modelMapper;

    private UserDaoImpl userDaoImpl;

    @Autowired
    public UserRepositoryImpl(ModelMapper modelMapper, UserDaoImpl userDaoImpl) {
        this.modelMapper = modelMapper;
        this.userDaoImpl = userDaoImpl;
    }

    @PostConstruct
    private void initialize() {
        modelMapper.addConverter(timestampToLocalDateTime());
    }

    @Override
    public List<User> findAll() {
        return userDaoImpl.findAll().stream().map(data -> modelMapper.map(data, User.class)).collect(Collectors.toList());
    }

    @Override
    public List<User> findById(String identifier) {
        return userDaoImpl.findById(identifier).stream().map(data -> modelMapper.map(data, User.class))
                .collect(Collectors.toList());
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

    @Override
    public List<User> findByUserName(String username) {
        return userDaoImpl.findByUserName(username).stream().map(data -> modelMapper.map(data, User.class))
                .collect(Collectors.toList());
    }

}
