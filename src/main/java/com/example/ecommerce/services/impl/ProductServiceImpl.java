package com.example.ecommerce.services.impl;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository repository;

    public Optional<Product> getProductById(Long productId)
    {
        Optional<Product> product = repository.findById(productId);
        return product;

    }

}
