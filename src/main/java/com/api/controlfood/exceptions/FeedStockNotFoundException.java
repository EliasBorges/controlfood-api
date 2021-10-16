package com.api.controlfood.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FeedStockNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;
}
