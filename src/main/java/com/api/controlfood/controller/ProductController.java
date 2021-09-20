package com.api.controlfood.controller;

import com.api.controlfood.controller.dto.request.ProductRequest;
import com.api.controlfood.controller.dto.response.IdResponse;
import com.api.controlfood.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService service;

    @ResponseStatus(CREATED)
    @PostMapping
    public IdResponse create(@Valid @RequestBody ProductRequest request) {
        return new IdResponse(service.create(request));
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/{id}")
    public String update(
            @PathVariable String id,
            @Valid @RequestBody ProductRequest request
    ) {
        return service.update(id, request);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

/*    @ResponseStatus(OK)
    @PutMapping(value = "/{id}")
    public String update(
            @PathVariable String id,
            @Valid @RequestBody Product request
    ) {
        return service.update(id, request);
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
    }*/
}
