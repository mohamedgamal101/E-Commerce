package com.example.ecommerce.utils;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.repositories.CategoryRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" Called Directly After Application Started");

//        Faker faker = new Faker();
//
//        List<Category> categories =new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//        Category category =new Category();
//        category.setName(faker.commerce().department());
//        categories.add(category);
//        }
//        categoryRepository.saveAll(categories);
//
//
//        List<Category> fromDBList = categoryRepository.findAll();
//
//
//
//
//        Collections.shuffle(fromDBList);
//        Set<Category> randomSet = new HashSet<Category>(fromDBList.subList(0, 5));
//
//        for (int i = 0; i < 200; i++) {
//
//            Product product =new Product();
//            product.setName(faker.commerce().productName());
//            product.setPrice(Double.parseDouble(faker.commerce().price()));
//            product.setDescription(faker.commerce().department());
//
//            product.setCategories(randomSet);
//            productRepository.save(product);
//        }



    }
}