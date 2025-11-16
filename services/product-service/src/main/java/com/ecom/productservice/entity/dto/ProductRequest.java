package com.ecom.productservice.entity.dto;

import com.ecom.productservice.entity.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    @NotNull(message = "Product name cannot be null")
    private String name;
    @NotNull(message = "Product description cannot be null")
    private String description;
    @Positive(message = "Product quantity must be postive")
    private Integer quantity;
    @Positive(message = "Product price must be postive")
    private BigDecimal price;
    @NotNull(message = "Category id cannot be null")
    private UUID categoryId;
}
