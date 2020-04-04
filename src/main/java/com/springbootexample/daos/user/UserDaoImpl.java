package com.springbootexample.daos.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository("userDaoImpl")
public class UserDaoImpl extends JdbcDaoSupport implements UserDao<UserRecord> {

    private DataSource dataSource;

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<UserRecord> findById(String identifier) {
        Object[] objParam = new Object[]{identifier};
        assert this.getJdbcTemplate() != null;
        return this.getJdbcTemplate().query("select * from user where identifier = ?", new UserRecordMapper(), objParam);
    }

    @Override
    public List<UserRecord> findAll() {

        assert this.getJdbcTemplate() != null;
        return this.getJdbcTemplate().query("select * from user", new UserRecordMapper());
    }

    @Override
    public String create(UserRecord record) {

        return null;
    }

    @Override
    public UserRecord update(UserRecord record) {

        return null;
    }

    @Override
    public void deleteById(String id) {


    }

    @Override
    public void delete(UserRecord record) {


    }

    @Override
    public long count() {

        return 0;
    }

    @Override
    public boolean existsById(String identifier) {

        return false;
    }

    @Override
    public List<UserRecord> findByUserName(String username) {
        Object[] objParam = new Object[]{username};
        return this.getJdbcTemplate().query("select * from user where user_name = ?", new UserRecordMapper(), objParam);
    }

}
