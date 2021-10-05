package com.api.controlfood.service.impl;

import com.api.controlfood.ControlFoodMessage;
import com.api.controlfood.controller.dto.request.product.ProductRequest;
import com.api.controlfood.entity.Product;
import com.api.controlfood.exceptions.ProductNotFoundException;
import com.api.controlfood.exceptions.SalueValueLessThanCostValueException;
import com.api.controlfood.repository.ProductRepository;
import com.api.controlfood.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService implements IProductService {
    private final ProductRepository repository;

    public String create(ProductRequest request) {
        validSalueValue(request);
        return Product.create(request, repository);
    }

    public String update(String id, ProductRequest request) {
        Product product = repository.findById(id).orElseThrow(() -> {
            log.error("[PRODUCT] - Not update, id product = {} not found", id);

            throw new ProductNotFoundException(ControlFoodMessage.PRODUCT_NOT_FOUND);
        });

        validSalueValue(request);

        log.info("[PRODUCT] - Update product, id = {}, productBefore = {}, productAfter = {}",
                id,
                request,
                product);

        return product.update(request, repository);
    }

    public void delete(String id) {
        Product product = repository.findById(id).orElseThrow(() -> {
            log.error("[PRODUCT] - Not delete, id product = {} not found", id);

            throw new ProductNotFoundException(ControlFoodMessage.PRODUCT_NOT_FOUND);
        });

        log.info("[PRODUCT] - Delete product = {}", product);

        product.delete(product, repository);
    }

    public Product findById(String id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("[PRODUCT] - Not found, id product = {}", id);

            throw new ProductNotFoundException(ControlFoodMessage.PRODUCT_NOT_FOUND);
        });
    }

    public Product findByName(String name) {
        return repository.findByNameContaining(name).orElseThrow(() -> {
            log.error("[PRODUCT] - Not found, name product = {}", name);

            throw new ProductNotFoundException(ControlFoodMessage.PRODUCT_NOT_FOUND);
        });
    }

    public Page<Product> findAll(Pageable page) {
        return repository.findAll(page);
    }

    private void validSalueValue(ProductRequest request) {
        if (request.getSaleValue() <= request.getCostValue()) {
            log.error("[PRODUCT] - Salue value {} less than cost value {}",
                    request.getSaleValue(), request.getCostValue());

            throw new SalueValueLessThanCostValueException(ControlFoodMessage.SALUE_VALUE_BOTTOM_COST_VALUE);
        }
    }
}
