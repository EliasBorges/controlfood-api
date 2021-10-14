package com.api.controlfood.entity;

import com.api.controlfood.controller.dto.request.product.ProductRequest;
import com.api.controlfood.enums.TypeProduct;
import com.api.controlfood.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, name = "sale_value")
    private Double saleValue;

    @Column(nullable = false, name = "cost_value")
    private Double costValue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeProduct type;

    public static String create(
            ProductRequest request,
            ProductRepository repository
    ){
        return repository.save(new Product(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getDescribe(),
                request.getSaleValue(),
                request.getCostValue(),
                request.getType()
        )).id;
    }

    public String update(
            ProductRequest request,
            ProductRepository repository
    ) {
        this.name = request.getName();
        this.description = request.getDescribe();
        this.saleValue = request.getSaleValue();
        this.costValue = request.getCostValue();
        this.type = request.getType();

        return repository.save(this).id;
    }

    public void delete(
            Product product,
            ProductRepository repository
    ) {
        repository.delete(product);
    }
}
