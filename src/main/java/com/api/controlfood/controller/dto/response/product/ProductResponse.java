package com.api.controlfood.controller.dto.response.product;

import com.api.controlfood.entity.FeedStock;
import com.api.controlfood.entity.Product;
import com.api.controlfood.enums.TypeProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private Double saleValue;
    private Double costValue;
    private TypeProduct type;
    private List<FeedStock> stocks;

    public static ProductResponse fromProduct(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getSaleValue(),
                product.getCostValue(),
                product.getType(),
                product.getStocks());
    }
}
