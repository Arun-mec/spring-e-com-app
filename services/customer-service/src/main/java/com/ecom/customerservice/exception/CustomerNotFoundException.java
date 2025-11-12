package com.ecom.customerservice.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class CustomerNotFoundException extends RuntimeException {
    private final String errMessage;

    public CustomerNotFoundException(String errMessage) {
        this.errMessage = errMessage;
    }
}
