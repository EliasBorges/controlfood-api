package com.api.controlfood.entity;

import com.api.controlfood.controller.dto.request.feedstock.FeedStockRequest;
import com.api.controlfood.repository.FeedStockRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "feed_stock")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedStock {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double value;

    public static String create(
            FeedStockRequest request,
            FeedStockRepository repository
    ) {
        return repository.save(new FeedStock(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getValue()
        )).id;
    }

    public String update(
            FeedStockRequest request,
            FeedStockRepository repository
    ) {
        this.name = request.getName();
        this.value = request.getValue();

        return repository.save(this).id;
    }

    public void delete(
            FeedStockRepository repository
    ) {
        repository.delete(this);
    }
}
