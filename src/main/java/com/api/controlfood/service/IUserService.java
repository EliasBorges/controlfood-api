package com.api.controlfood.service;

import com.api.controlfood.controller.dto.request.UserRequest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface IUserService {
    String create(@Valid @RequestBody UserRequest request);
}
