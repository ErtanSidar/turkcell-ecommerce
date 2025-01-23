package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.User;
import com.turkcell.ecommerce.service.dtos.user.CreateUserRequest;
import com.turkcell.ecommerce.service.dtos.user.LoginUserRequest;

public interface UserService {
    User getById(int id);
    void add(CreateUserRequest createUserRequest);
    String login(LoginUserRequest loginUserRequest);
}
