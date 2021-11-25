package com.api.controlfood.controller.dto.response.product;

import com.api.controlfood.entity.Product;
import com.api.controlfood.enums.TypeProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String describe;
    private Double saleValue;
    private Double costValue;
    private TypeProduct type;
    private List<FeedStockProductResponse> stocks;
    private Double amountStocks;

    public static ProductResponse fromProduct(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                Double.parseDouble(
                        String.valueOf(
                                System.out.format("%05.2f \t| \n", product.getSaleValue())
                        )
                ),
                Double.parseDouble(
                        String.valueOf(
                                System.out.format("%05.2f \t| \n", product.getCostValue())
                        )
                ),
                product.getType(),
                product.getStocks()
                        .stream()
                        .map(FeedStockProductResponse::fromStock)
                        .collect(Collectors.toList()),
                Double.parseDouble(
                        String.valueOf(
                                System.out.format("%05.2f \t| \n", FeedStockProductResponse.amount(product.getStocks()))
                        )
                )
        );
    }
}
