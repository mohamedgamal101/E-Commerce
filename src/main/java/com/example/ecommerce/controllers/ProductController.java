package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Product;
import com.example.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;


    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String productId)
    {
        Product product = service.getProductById(Long.valueOf(productId)).get();
        return  new ResponseEntity<>(product, HttpStatus.OK);
    }


}
