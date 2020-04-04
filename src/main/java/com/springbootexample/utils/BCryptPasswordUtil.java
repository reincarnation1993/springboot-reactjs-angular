package com.springbootexample.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordUtil {

    public String bCryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkBCryptPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
