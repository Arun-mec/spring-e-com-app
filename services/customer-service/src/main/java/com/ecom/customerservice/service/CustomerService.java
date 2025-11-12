package com.ecom.customerservice.service;

import com.ecom.customerservice.entity.Customer;
import com.ecom.customerservice.entity.dto.CustomerDto;
import com.ecom.customerservice.entity.dto.CustomerRequest;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(String id);

    CustomerDto createCustomer(CustomerRequest customerRequest);

    CustomerDto updateCustomer(String id, CustomerRequest updCustomerRequest);

    void deleteCustomer(String id);

}
