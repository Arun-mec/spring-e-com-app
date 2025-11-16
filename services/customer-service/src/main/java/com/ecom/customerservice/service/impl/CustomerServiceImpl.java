package com.ecom.customerservice.service.impl;

import com.ecom.customerservice.entity.Customer;
import com.ecom.customerservice.entity.dto.CustomerDto;
import com.ecom.customerservice.entity.dto.CustomerRequest;
import com.ecom.customerservice.exception.CustomerNotFoundException;
import com.ecom.customerservice.mapper.CustomerMapper;
import com.ecom.customerservice.repository.CustomerRepository;
import com.ecom.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer ->
                customerMapper.toCustomerDto(customer)).toList();
    }

    @Override
    public CustomerDto getCustomerById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                    String.format("Cannot get customer:: No customer found with id: %s", id)
                ));
        return customerMapper.toCustomerDto(customer);
    }

    @Override
    public CustomerDto createCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRepository.save(customerMapper.toCustomer(customerRequest));
        return customerMapper.toCustomerDto(customer);
    }

    @Override
    public CustomerDto updateCustomer(String id, CustomerRequest updCustomerRequest) {
        Customer currCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                    String.format("Cannot update customer:: No customer found with id: %s", id)
                ));
        if (updCustomerRequest.getFirstname()!=null)
            currCustomer.setFirstname(updCustomerRequest.getFirstname());
        if (updCustomerRequest.getLastname()!=null)
            currCustomer.setLastname(updCustomerRequest.getLastname());
        if (updCustomerRequest.getEmail()!=null)
            currCustomer.setEmail(updCustomerRequest.getEmail());
        if (updCustomerRequest.getAddress()!=null)
            currCustomer.setAddress(updCustomerRequest.getAddress());
        Customer updCustomer = customerRepository.save(currCustomer);

        return customerMapper.toCustomerDto(updCustomer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot delete customer:: No customer found with id: %s", id)
                ));
        customerRepository.deleteById(id);
    }

}
