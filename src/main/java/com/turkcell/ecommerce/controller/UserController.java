package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.entity.User;
import com.turkcell.ecommerce.service.abstracts.UserService;
import com.turkcell.ecommerce.service.dtos.requests.userRequests.LoginUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @PostMapping("login")
    public String login(@RequestBody LoginUserRequest loginUserRequest) {
        return userService.login(loginUserRequest);
    }
}
