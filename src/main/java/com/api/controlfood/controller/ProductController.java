package com.api.controlfood.controller;

import com.api.controlfood.controller.dto.request.product.ProductRequest;
import com.api.controlfood.controller.dto.response.base.IdResponse;
import com.api.controlfood.controller.dto.response.product.DiscountMarginByProductResponse;
import com.api.controlfood.controller.dto.response.product.ProductResponse;
import com.api.controlfood.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.http.HttpStatus.*;

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
    public IdResponse update(
            @PathVariable String id,
            @Valid @RequestBody ProductRequest request
    ) {
        return new IdResponse(service.update(id, request));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/{id}")
    public ProductResponse findById(
            @PathVariable String id
    ) {
        return ProductResponse.fromProduct(service.findById(id));
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/name")
    public ProductResponse findByName(
            @RequestParam("name") String name
    ) {
        return ProductResponse.fromProduct(service.findByName(name));
    }

    @ResponseStatus(OK)
    @GetMapping
    public Page<ProductResponse> findAll(
            @PageableDefault(
                    sort = "name",
                    direction = ASC,
                    size = 20
            )
                    Pageable page
    ) {
        return service.findAll(page).map(ProductResponse::fromProduct);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "{id}/discount")
    public DiscountMarginByProductResponse findDiscountMarginByProduct(@PathVariable String id) {
        return service.findDiscountMarginByProduct(id);
    }
}
