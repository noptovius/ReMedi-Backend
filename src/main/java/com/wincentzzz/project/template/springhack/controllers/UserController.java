package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.response.BaseResponse;
import com.wincentzzz.project.template.springhack.dto.response.UserResponse;
import com.wincentzzz.project.template.springhack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private BaseResponse<UserResponse> test() {
        UserResponse userResponse = userService.login();
        return BaseResponse.<UserResponse>builder()
                .code(200)
                .data(userResponse)
                .build();
    }
}
