package com.ecom.productservice.service;

import com.ecom.productservice.entity.dto.ProductDto;
import com.ecom.productservice.entity.dto.ProductRequest;
import com.ecom.productservice.entity.dto.PurchaseDto;
import com.ecom.productservice.entity.dto.PurchaseRequest;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(UUID id);

    ProductDto createProduct(ProductRequest productRequest);

    List<PurchaseDto> purchaseProducts(List<PurchaseRequest> purchaseRequests);
}
