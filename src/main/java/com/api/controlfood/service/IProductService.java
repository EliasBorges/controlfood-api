package com.api.controlfood.service;

import com.api.controlfood.controller.dto.request.ProductRequest;

public interface IProductService {
    String create(ProductRequest request);

    String update(String id, ProductRequest request);

    void delete(String id);
/*
    Product findByName(String id);

    Page<Product> findAll(Pageable page);

    Product findProductFeasibility (String id);*/
}
