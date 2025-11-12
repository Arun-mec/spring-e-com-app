package com.ecom.customerservice.entity.dto;

import com.ecom.customerservice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestDto {
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
