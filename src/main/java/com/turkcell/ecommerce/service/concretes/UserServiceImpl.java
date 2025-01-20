package com.turkcell.ecommerce.service.concretes;

import com.turkcell.ecommerce.core.exception.type.BusinessException;
import com.turkcell.ecommerce.core.jwt.JwtService;
import com.turkcell.ecommerce.entity.User;
import com.turkcell.ecommerce.repository.UserRepository;
import com.turkcell.ecommerce.service.abstracts.UserService;
import com.turkcell.ecommerce.service.dtos.requests.userRequests.LoginUserRequest;
import com.turkcell.ecommerce.service.rules.UserBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserBusinessRules userBusinessRules;
    private final JwtService jwtService;

    @Override
    public void add(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public String login(LoginUserRequest loginUserRequest) {

        // userBusinessRules.checkUserExists(loginUserRequest);

        User dbUser = userRepository
                .findByEmail(loginUserRequest.getEmail())
                .orElseThrow(() -> new BusinessException("Invalid or wrong credentials."));


        boolean isPasswordCorrect = bCryptPasswordEncoder
                .matches(loginUserRequest.getPassword(), dbUser.getPassword());

        if(!isPasswordCorrect)
            throw new BusinessException("Invalid or wrong credentials.");

        return this.jwtService.generateToken(dbUser.getEmail());
    }
}
