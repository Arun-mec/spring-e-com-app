package com.ecom.productservice.service.impl;

import com.ecom.productservice.entity.Product;
import com.ecom.productservice.entity.dto.ProductDto;
import com.ecom.productservice.entity.dto.ProductRequest;
import com.ecom.productservice.entity.dto.PurchaseDto;
import com.ecom.productservice.entity.dto.PurchaseRequest;
import com.ecom.productservice.exception.ProductNotFoundException;
import com.ecom.productservice.exception.ProductPurchaseException;
import com.ecom.productservice.mapper.ProductMapper;
import com.ecom.productservice.repository.ProductRepository;
import com.ecom.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product ->
                productMapper.toProductDto(product)).toList();
    }

    @Override
    public ProductDto getProductById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Cannot get product:: No product found with id: %s", id)));
        return productMapper.toProductDto(product);
    }

    @Override
    public ProductDto createProduct(ProductRequest productRequest) {
        Product newProduct = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductDto(newProduct);
    }

    @Override
    public List<PurchaseDto> purchaseProducts(List<PurchaseRequest> purchaseRequests) {
        List<PurchaseDto> purchaseDtos = new ArrayList<>();
        List<UUID> productIds = purchaseRequests.stream().map(PurchaseRequest::getProductId).toList();
        List<Product> currProducts = productRepository.findAllByIdOrderByIdAsc(productIds);
        if (productIds.size()!= currProducts.size())
            throw new ProductPurchaseException("One or more products are not found!");

        var currProductRequest = purchaseRequests.stream()
                .sorted(Comparator.comparing(PurchaseRequest::getProductId)).toList();

        for (int purchaseCount=0; purchaseCount<currProducts.size();purchaseCount++) {
            var currProduct = currProducts.get(purchaseCount);
            var currProductReq = currProductRequest.get(purchaseCount);
            if (currProduct.getQuantity()<currProductReq.getQuantity())
                throw new ProductPurchaseException("Insufficient stock for product:: "+currProduct.getName());

            currProduct.setQuantity(currProduct.getQuantity()-currProductReq.getQuantity());
            productRepository.save(currProduct);
            purchaseDtos.add(productMapper.toPurchaseDto(currProduct, currProductReq.getQuantity()));
        }

        return purchaseDtos;
    }
}
