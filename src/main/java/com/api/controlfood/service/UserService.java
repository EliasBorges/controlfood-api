package com.api.controlfood.service;

import com.api.controlfood.ControlFoodMessage;
import com.api.controlfood.controller.dto.request.UserRequest;
import com.api.controlfood.controller.dto.response.UserIdResponse;
import com.api.controlfood.entity.User;
import com.api.controlfood.exceptions.UserExistException;
import com.api.controlfood.exceptions.UserNotFoundException;
import com.api.controlfood.repository.UserRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@AllArgsConstructor
@Service
@Slf4j
public class UserService implements IUserService {
    private final UserRepository repository;

    public String create(UserRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new UserExistException(ControlFoodMessage.VALIDATION_EMAIL_ALREADY_EXISTS);
        }

        return User.create(request, repository);
    }

    public String update(String id, UserRequest request) {
        User user = repository.findById(id).orElseThrow(() -> {
            log.error("User not update, user = {} not found", id);

            throw new UserNotFoundException(ControlFoodMessage.USER_NOT_FOUND);
        });

        log.info("Update user, id = {}, userBefore = {}, userAfter = {}",
                id,
                request,
                user);

        return user.update(request, repository);
    }

    public void delete(String id){
        User user = repository.findById(id).orElseThrow(() -> {
            log.error("User not update, user = {} not found", id);

            throw new UserNotFoundException(ControlFoodMessage.USER_NOT_FOUND);
        });

        log.info("Delete user = {}", user);

        user.delete(user, repository);
    }
}
