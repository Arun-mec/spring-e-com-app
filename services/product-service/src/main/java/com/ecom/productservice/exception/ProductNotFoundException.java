package com.ecom.productservice.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ProductNotFoundException extends RuntimeException {
    private final String message;
    public ProductNotFoundException(String message) {
        this.message = message;
    }
}
