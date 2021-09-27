package com.api.controlfood.controller.dto.request.cashier;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class OpenCashierRequest {
    @Positive(message = "{validation.positive}")
    private Double openingBalance;
}
