package com.luv2code.springdemo.gofoodie.service;

import com.luv2code.springdemo.gofoodie.entity.User;

public interface UserService
{
    User find();
    void save(User user);
}
