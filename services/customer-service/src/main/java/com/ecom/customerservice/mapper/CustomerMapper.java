package com.ecom.customerservice.mapper;

import com.ecom.customerservice.entity.Customer;
import com.ecom.customerservice.entity.dto.CustomerDto;
import com.ecom.customerservice.entity.dto.CustomerRequest;
import com.ecom.customerservice.entity.dto.CustomerRequestDto;

public class CustomerMapper {

    public CustomerDto toCustomerDto(Customer customer) {
        if (customer==null)
            return null;
        return CustomerDto.builder()
                .id(customer.getId())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }

    public CustomerRequest toCustomerRequest(CustomerRequestDto customerRequestDto) {
        if (customerRequestDto==null)
            return null;
        return CustomerRequest.builder()
                .firstname(customerRequestDto.getFirstname())
                .lastname(customerRequestDto.getLastname())
                .email(customerRequestDto.getEmail())
                .address(customerRequestDto.getAddress())
                .build();
    }

}
