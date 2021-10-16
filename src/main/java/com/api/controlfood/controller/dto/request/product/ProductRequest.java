package com.api.controlfood.controller.dto.request.product;

import com.api.controlfood.entity.FeedStock;
import com.api.controlfood.enums.TypeProduct;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{validation.blank}")
    private TypeProduct type;

    @NotNull(message = "{validation.blank}")
    private List<FeedStock> stocks;
}
