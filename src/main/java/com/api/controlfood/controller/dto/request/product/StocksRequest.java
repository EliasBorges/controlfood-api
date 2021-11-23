package com.api.controlfood.controller.dto.request.product;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class StocksRequest {
    @NotBlank(message = "{validation.blank}")
    private String id;
}
