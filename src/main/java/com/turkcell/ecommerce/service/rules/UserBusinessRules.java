package com.turkcell.ecommerce.service.rules;

import com.turkcell.ecommerce.core.business.abstracts.MessageService;
import com.turkcell.ecommerce.core.exception.type.BusinessException;
import com.turkcell.ecommerce.entity.User;
import com.turkcell.ecommerce.repository.UserRepository;
import com.turkcell.ecommerce.service.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private final UserRepository userRepository;
    private final MessageService messageService;

    public void checkUserExists(User user) {
        Optional<User> dbUser = userRepository
                .findById(user.getId());

        if (dbUser.isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.USER_NOT_FOUND));
        }

    }
}
