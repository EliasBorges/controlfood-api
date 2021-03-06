package com.api.controlfood.controller.dto.response.product;

import com.api.controlfood.entity.FeedStock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedStockProductResponse {
    private String name;
    private String value;

    public static FeedStockProductResponse fromStock(FeedStock stock){
        return new FeedStockProductResponse(
                stock.getName(),
                "R$" + stock.getValue()
        );
    }

    public static Double amount(List<FeedStock> stocks){
        AtomicReference<Double> amount = new AtomicReference<>(0.0);

        stocks.forEach(stock ->  {
            amount.updateAndGet(v -> v + stock.getValue());
        });

        return amount.get();
    }
}
