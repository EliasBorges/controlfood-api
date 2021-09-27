package com.api.controlfood.controller.dto.request.cashier;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SearchCashierDateRequest {
    @NotBlank(message = "{validation.blank}")
    private LocalDate date;
}
