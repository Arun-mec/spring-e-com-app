package com.ecom.customerservice.controller;

import com.ecom.customerservice.entity.Customer;
import com.ecom.customerservice.entity.dto.CustomerRequest;
import com.ecom.customerservice.entity.dto.CustomerRequestDto;
import com.ecom.customerservice.entity.dto.CustomerDto;
import com.ecom.customerservice.mapper.CustomerMapper;
import com.ecom.customerservice.repository.CustomerRepository;
import com.ecom.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    private CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customerDtos = customerService.getAllCustomers();
        return ResponseEntity.ok(customerDtos);
    }

    @GetMapping("/${id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        CustomerRequest customerRequest = customerMapper.toCustomerRequest(customerRequestDto);
        CustomerDto nwCustomer = customerService.createCustomer(customerRequest);
        return new ResponseEntity<>(nwCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/${id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable String id, @RequestBody CustomerRequestDto updCustomerRequestDto) {
        CustomerRequest updCustomerRequest = customerMapper.toCustomerRequest(updCustomerRequestDto);
        CustomerDto updCustomer = customerService.updateCustomer(id, updCustomerRequest);
        return ResponseEntity.ok(updCustomer);
    }

    @DeleteMapping("/${id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
