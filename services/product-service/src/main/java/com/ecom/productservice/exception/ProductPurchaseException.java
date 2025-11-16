package com.ecom.productservice.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ProductPurchaseException extends RuntimeException {
    private final String message;

    public ProductPurchaseException(String message) {
        this.message = message;
    }
}
