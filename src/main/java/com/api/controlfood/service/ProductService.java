package com.api.controlfood.service;

import com.api.controlfood.controller.dto.request.ProductRequest;
import com.api.controlfood.entity.Product;
import com.api.controlfood.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService implements IProductService{
    private final ProductRepository repository;

    @Override
    public String create(ProductRequest request) {
        return Product.create(request, repository);
    }
}
