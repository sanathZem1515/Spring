package com.luv2code.springdemo.gofoodie.dao;

import com.luv2code.springdemo.gofoodie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User,String>
{
    User findByUsername(String username);
}
