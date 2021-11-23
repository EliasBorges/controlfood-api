package com.api.controlfood.controller.dto.response.feedstock;

import com.api.controlfood.entity.FeedStock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedStockResponse {
    private String id;
    private String name;
    private Double value;

    public static FeedStockResponse fromStock(FeedStock stock){
        return new FeedStockResponse(
                stock.getId(),
                stock.getName(),
                stock.getValue());
    }
}
