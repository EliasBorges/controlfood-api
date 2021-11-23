package com.api.controlfood.controller.dto.request.feedstock;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FeedStockRequest {
    @NotBlank(message = "{validation.blank}")
    private String name;

    @Positive(message = "{validation.positive}")
    private Double value;
}
