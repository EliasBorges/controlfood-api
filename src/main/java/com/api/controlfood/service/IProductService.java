package com.api.controlfood.service;

import com.api.controlfood.controller.dto.request.ProductRequest;
import com.api.controlfood.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    String create(ProductRequest request);

    String update(String id, ProductRequest request);

    void delete(String id);

    Product findById(String id);

    Page<Product> findAll(Pageable page);

    /*  Product findProductFeasibility (String id);*/
}
