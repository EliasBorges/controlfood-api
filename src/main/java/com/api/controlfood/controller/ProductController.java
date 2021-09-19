package com.api.controlfood.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.http.HttpStatus.*;

/*@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService service;

    @ResponseStatus(CREATED)
    @PostMapping
    public String create(@Valid @RequestBody Product request) {
        return service.create(request);
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/{id}")
    public String update(
            @PathVariable String id,
            @Valid @RequestBody Product request
    ) {
        return service.update(id, request);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/{id}")
    public Product findById(
            @PathVariable String id
    ) {
        return UserResponse.fromUser(service.findById(id));
    }

    @ResponseStatus(OK)
    @GetMapping
    public Page<Product> findAll(
            @PageableDefault(
                    sort = "email",
                    direction = ASC,
                    size = 20)
                    Pageable page
    ) {
        return service.findAll(page).map(UserResponse::fromUser);
    }
}*/
