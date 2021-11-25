package com.api.controlfood.controller.dto.response.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountMarginByProductResponse {
    private String value;
    private Boolean isPositive;
}
