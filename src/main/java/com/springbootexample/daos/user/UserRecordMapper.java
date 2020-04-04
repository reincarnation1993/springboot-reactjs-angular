package com.springbootexample.daos.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRecordMapper implements RowMapper<UserRecord> {

    @Override
    public UserRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserRecord userRecord = new UserRecord();
        userRecord.setIdentifier(rs.getString("identifier"));
        userRecord.setUserName(rs.getString("user_name"));
        userRecord.setPassword(rs.getString("password"));
        userRecord.setEmail(rs.getString("email"));
        userRecord.setAvatarPath(rs.getString("avatar_path"));
        userRecord.setAvatarName(rs.getString("avatar_name"));
        userRecord.setDateOfBirth(rs.getTimestamp("date_of_birth"));
        userRecord.setAddressId(rs.getString("address_id"));
        userRecord.setDeleteFlg(rs.getBoolean("delete_flg"));
        userRecord.setCreatedAt(rs.getTimestamp("created_at"));
        userRecord.setUpdatedAt(rs.getTimestamp("updated_at"));
        return userRecord;
    }

}