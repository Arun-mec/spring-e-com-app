package com.ecom.customerservice.entity.dto;

import com.ecom.customerservice.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class CustomerRequest {
    @NotNull(message = "Customer firstname can't be empty")
    private String firstname;

    @NotNull(message = "Customer lastname can't be empty")
    private String lastname;

    @NotNull(message = "Customer email can't be empty")
    @Email(message = "Customer email is not valid")
    private String email;

    private Address address;
}
