package com.api.controlfood.controller;

import com.api.controlfood.controller.dto.request.UserRequest;
import com.api.controlfood.controller.dto.request.UserUpdateRequest;
import com.api.controlfood.controller.dto.response.UserIdResponse;
import com.api.controlfood.controller.dto.response.UserResponse;
import com.api.controlfood.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService service;

    @ResponseStatus(CREATED)
    @PostMapping
    public UserIdResponse create(@Valid @RequestBody UserRequest request) {
        return new UserIdResponse(service.create(request));
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/{id}")
    public UserIdResponse update(
            @PathVariable String id,
            @Valid @RequestBody UserUpdateRequest request
    ) {
        return new UserIdResponse(service.update(id, request));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/{id}")
    public UserResponse findById(
            @PathVariable String id
    ) {
        return UserResponse.fromUser(service.findById(id));
    }
}
