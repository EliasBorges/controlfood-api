package com.api.controlfood.service;

import com.api.controlfood.controller.dto.request.UserRequest;
import com.api.controlfood.controller.dto.request.UserUpdateRequest;
import com.api.controlfood.entity.User;

public interface IUserService {
    String create(UserRequest request);

    String update(String id, UserUpdateRequest request);

    void delete(String id);

    User findById(String id);
}
