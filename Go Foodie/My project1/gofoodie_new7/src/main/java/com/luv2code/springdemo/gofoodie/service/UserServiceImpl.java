package com.luv2code.springdemo.gofoodie.service;

import com.luv2code.springdemo.gofoodie.dao.UserJpaRepository;
import com.luv2code.springdemo.gofoodie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    UserJpaRepository userJpaRepository;

    public String getUserName()
    {
        String currentUserName=null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }

        return  currentUserName;
    }
    @Override
    public User find()
    {
        String username=getUserName();
        return userJpaRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        user.setUsername(getUserName());
        user.setEnabled(1);
        user.setPassword("{noop}"+user.getPassword());
        userJpaRepository.save(user);

    }
}
