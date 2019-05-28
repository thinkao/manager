package com.wxy.service.impl;

import com.wxy.dao.UserRepository;
import com.wxy.pojo.Users;
import com.wxy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void update(Users users) {
        userRepository.save(users);
    }
}