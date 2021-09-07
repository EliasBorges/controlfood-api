package com.api.controlfood.service;

import com.api.controlfood.controller.dto.request.UserRequest;
import com.api.controlfood.entity.User;
import com.api.controlfood.exceptions.UserExistException;
import com.api.controlfood.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class UserService implements IUserService {
    private final UserRepository repository;

    public String create(UserRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new UserExistException("validation.email.already.exists");
        }

        return User.create(request, repository);
    }
}
