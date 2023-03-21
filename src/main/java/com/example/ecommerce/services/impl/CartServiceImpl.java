package com.example.ecommerce.services.impl;

import com.example.ecommerce.entities.CartItem;
import com.example.ecommerce.repositories.CartRepository;
import com.example.ecommerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    public Optional<CartItem> getCartById(Long cartId)
    {
        Optional<CartItem> cartItem = cartRepository.findById(cartId);
        return cartItem;

    }
}
