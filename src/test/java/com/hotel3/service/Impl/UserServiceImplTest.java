package com.hotel3.service.Impl;

import com.hotel3.mapper.UserMapper;
import com.hotel3.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Autowired
    private UserMapper UserMapper;
    @Test
    public void getUserByNameAndPsw() {

       User u= UserMapper.getUserByNameAndPsw("wys","123456");
        System.out.println(u);
    }

    @Test
    public void addUser() {
    }
}