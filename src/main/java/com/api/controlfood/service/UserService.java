package com.api.controlfood.service;

import com.api.controlfood.ControlFoodMessage;
import com.api.controlfood.controller.dto.request.UserRequest;
import com.api.controlfood.controller.dto.request.UserUpdateRequest;
import com.api.controlfood.entity.User;
import com.api.controlfood.exceptions.UserExistException;
import com.api.controlfood.exceptions.UserNotFoundException;
import com.api.controlfood.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class UserService implements IUserService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public String create(UserRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            log.error("[USER] - Not create, email user = {} exists", request.getEmail());

            throw new UserExistException(ControlFoodMessage.VALIDATION_EMAIL_ALREADY_EXISTS);
        }

        return User.create(request, repository, passwordEncoder);
    }

    public String update(String id, UserUpdateRequest request) {
        User user = repository.findById(id).orElseThrow(() -> {
            log.error("[USER] - Not update, id user = {} not found", id);

            throw new UserNotFoundException(ControlFoodMessage.USER_NOT_FOUND);
        });

        log.info("[USER] - Update user, id = {}, userBefore = {}, userAfter = {}",
                id,
                request,
                user);

        return user.update(request, repository, passwordEncoder);
    }

    public void delete(String id) {
        User user = repository.findById(id).orElseThrow(() -> {
            log.error("[USER] - Not delete, id user = {} not found", id);

            throw new UserNotFoundException(ControlFoodMessage.USER_NOT_FOUND);
        });

        log.info("[USER] - Delete user = {}", user);

        user.delete(user, repository);
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("[USER] - Not found, id User = {}", id);

            throw new UserNotFoundException(ControlFoodMessage.USER_NOT_FOUND);
        });
    }
}
