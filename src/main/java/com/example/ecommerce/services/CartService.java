package com.example.ecommerce.services;

import com.example.ecommerce.entities.CartItem;

import java.util.Optional;

public interface CartService {
    public Optional<CartItem> getCartById(Long cartId);
}
