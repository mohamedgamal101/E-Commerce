package com.example.ecommerce.services;

import com.example.ecommerce.entities.Product;

import java.util.Optional;

public interface ProductService {
    public Optional<Product> getProductById(Long productId);
}
