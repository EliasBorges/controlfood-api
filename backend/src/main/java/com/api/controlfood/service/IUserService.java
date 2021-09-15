package com.api.controlfood.service;

import com.api.controlfood.controller.dto.request.UserRequest;
import com.api.controlfood.controller.dto.request.UserUpdateRequest;
import com.api.controlfood.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    String create(UserRequest request);

    String updatePassword(String id, UserUpdateRequest request);

    void delete(String id);

    User findById(String id);

    Page<User> findAll(Pageable page);
}
