package com.api.controlfood.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductRequest {
    @NotBlank(message = "{validation.blank}")
    private String name;

    @NotBlank(message = "{validation.blank}")
    private String describe;

    @Positive(message = "{validation.positive}")
    private Double saleValue;

    @Positive(message = "{validation.positive}")
    private Double costValue;
}
