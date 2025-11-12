package com.ecom.customerservice.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class Address {
    private String streetName;
    private String houseNumber;
    private String zipCode;
}
