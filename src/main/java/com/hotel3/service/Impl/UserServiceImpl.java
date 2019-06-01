package com.hotel3.service.Impl;

import com.hotel3.mapper.UserMapper;
import com.hotel3.model.User;
import com.hotel3.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource(name="UserMapper")
    private UserMapper userMapper;

    @Override
    public User getUserByNameAndPsw(String userName, String userPassword) {
        return userMapper.getUserByNameAndPsw(userName,userPassword);
    }

    @Override
    public int addUser(User u) {
        return userMapper.addUser(u);
    }
}
