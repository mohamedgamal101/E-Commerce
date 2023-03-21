package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.CartItem;
import com.example.ecommerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    CartService service;

    @GetMapping("{id}")
    public ResponseEntity<CartItem> getCartById(@PathVariable("id") String cartId)
    {
        CartItem cartItem = service.getCartById(Long.valueOf(cartId)).get();
        return  new ResponseEntity<>(cartItem, HttpStatus.OK);
    }
}
