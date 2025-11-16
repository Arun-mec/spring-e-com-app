package com.ecom.productservice.mapper;

import com.ecom.productservice.entity.Category;
import com.ecom.productservice.entity.Product;
import com.ecom.productservice.entity.dto.ProductDto;
import com.ecom.productservice.entity.dto.ProductRequest;
import com.ecom.productservice.entity.dto.PurchaseDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .category(product.getCategory())
                .build();
    }

    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .category(Category.builder()
                        .id(productRequest.getCategoryId())
                        .build())
                .build();
    }

    public PurchaseDto toPurchaseDto(Product currProduct, Integer quantity) {
        return PurchaseDto.builder()
                .id(currProduct.getId())
                .name(currProduct.getName())
                .description(currProduct.getDescription())
                .quantity(quantity)
                .build();
    }
}
