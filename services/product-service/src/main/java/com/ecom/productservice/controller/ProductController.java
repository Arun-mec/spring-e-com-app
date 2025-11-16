package com.ecom.productservice.controller;

import com.ecom.productservice.entity.Product;
import com.ecom.productservice.entity.dto.ProductDto;
import com.ecom.productservice.entity.dto.ProductRequest;
import com.ecom.productservice.entity.dto.PurchaseDto;
import com.ecom.productservice.entity.dto.PurchaseRequest;
import com.ecom.productservice.service.ProductService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtos = productService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable UUID id) {
        ProductDto productDto = productService.getProductById(id);
        return ResponseEntity.ok(productDto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Validated ProductRequest productRequest) {
        ProductDto productDto = productService.createProduct(productRequest);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<PurchaseDto>> purchaseProducts(@RequestBody @Validated List<PurchaseRequest> purchaseRequests) {
        return null;
    }

}
