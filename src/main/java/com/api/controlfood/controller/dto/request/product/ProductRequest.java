package com.api.controlfood.controller.dto.request.product;

import com.api.controlfood.enums.TypeProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductRequest {
    @NotBlank(message = "{validation.blank}")
    private String name;

    @NotBlank(message = "{validation.blank}")
    private String describe;

    @Positive(message = "{validation.positive}")
    private Double saleValue;

    @JsonIgnore
    private Double costValue = 0.0;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{validation.blank}")
    private TypeProduct type;

    @NotNull(message = "{validation.blank}")
    @Valid
    private List<StocksRequest> stocks;
}
