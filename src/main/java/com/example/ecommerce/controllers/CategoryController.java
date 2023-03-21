package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    CategoryService service;

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") String categoryId)
    {
        Category category = service.getCategoryById(Long.valueOf(categoryId)).get();
        return  new ResponseEntity<>(category, HttpStatus.OK);
    }
}
