package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.dto.response.UserResponse;
import com.wincentzzz.project.template.springhack.repositories.UserRepository;
import com.wincentzzz.project.template.springhack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse login() {
        UserResponse userResponse = UserResponse.builder()
                .username("Username")
                .password("Password")
                .build();
        return userResponse;
    }
}
