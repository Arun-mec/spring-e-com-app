package com.ecom.customerservice.entity.dto;

import com.ecom.customerservice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
