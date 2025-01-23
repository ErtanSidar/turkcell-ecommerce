package com.turkcell.ecommerce.service.dtos.user;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {

    @Email(message = "Invalid email format")
    private String email;

    private String password;
}
