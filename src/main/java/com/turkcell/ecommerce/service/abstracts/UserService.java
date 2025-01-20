package com.turkcell.ecommerce.service.abstracts;

import com.turkcell.ecommerce.entity.User;
import com.turkcell.ecommerce.service.dtos.requests.userRequests.LoginUserRequest;

public interface UserService {
    void add(User user);
    String login(LoginUserRequest loginUserRequest);
}
