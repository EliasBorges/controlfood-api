package com.api.controlfood.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TypeProduct {
    ALIMENTO("Alimento"), BEBIDA("Bebida");

    private String unitMeasurement;
}
