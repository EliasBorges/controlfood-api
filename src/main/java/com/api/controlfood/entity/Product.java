package com.api.controlfood.entity;

import com.api.controlfood.controller.dto.request.product.ProductRequest;
import com.api.controlfood.enums.TypeProduct;
import com.api.controlfood.repository.ProductRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @ToString.Exclude
    private List<FeedStock> stocks;

    public static String create(
            ProductRequest request,
            List<FeedStock> stocks,
            ProductRepository repository
    ){
        return repository.save(new Product(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getDescribe(),
                request.getSaleValue(),
                request.getCostValue(),
                request.getType(),
                stocks
        )).id;
    }

    public String update(
            ProductRequest request,
            List<FeedStock> stocks,
            ProductRepository repository
    ) {
        this.name = request.getName();
        this.description = request.getDescribe();
        this.saleValue = request.getSaleValue();
        this.costValue = request.getCostValue();
        this.type = request.getType();
        this.stocks = stocks;

        return repository.save(this).id;
    }

    @Transactional
    public void delete(
            ProductRepository repository
    ) {
        this.getStocks().removeAll(this.getStocks());
        repository.delete(this);
    }
}
