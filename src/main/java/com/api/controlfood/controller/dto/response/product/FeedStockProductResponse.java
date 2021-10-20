package com.api.controlfood.controller.dto.response.product;

import com.api.controlfood.controller.dto.response.feedstock.FeedStockResponse;
import com.api.controlfood.entity.FeedStock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedStockProductResponse {
    private String name;

    public static FeedStockProductResponse fromStock(FeedStock stock){
        return new FeedStockProductResponse(
                stock.getName()
        );
    }
}
