package com.api.controlfood.controller;

import com.api.controlfood.controller.dto.request.UserRequest;
import com.api.controlfood.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService service;

    @ResponseStatus(OK)
    @PostMapping
    public String create(@Valid @RequestBody UserRequest request) {
        return service.create(request);
    }
}
