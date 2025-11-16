package com.ecom.productservice.entity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseRequest {
    @NotNull(message = "Product id cannot be empty")
    private UUID productId;
    @NotNull(message = "Product quantity cannot be empty")
    private Integer quantity;
}
