package com.turkcell.ecommerce.controller;

import com.turkcell.ecommerce.service.abstracts.UserService;
import com.turkcell.ecommerce.service.dtos.user.CreateUserRequest;
import com.turkcell.ecommerce.service.dtos.user.LoginUserRequest;
import jakarta.validation.Valid;
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
    public void add(@RequestBody @Valid CreateUserRequest createUserRequest) {
        userService.add(createUserRequest);
    }

    @PostMapping("login")
    public String login(@RequestBody LoginUserRequest loginUserRequest) {
        return userService.login(loginUserRequest);
    }
}
