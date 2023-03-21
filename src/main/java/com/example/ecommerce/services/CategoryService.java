package com.example.ecommerce.services;

import com.example.ecommerce.entities.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CategoryService {
    public Optional<Category> getCategoryById(Long categoryId);
    }

