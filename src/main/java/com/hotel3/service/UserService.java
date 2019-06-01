package com.hotel3.service;


import com.hotel3.model.User;

public interface UserService {

    public User getUserByNameAndPsw(String userName, String userPassword);
    public int addUser(User u);
}
