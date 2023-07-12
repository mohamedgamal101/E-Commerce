package com.example.ecommerce.services;

import com.example.ecommerce.dtos.AuthRequest;
import com.example.ecommerce.dtos.AuthResponse;
import com.example.ecommerce.entities.User;

public interface SecurityService {
    public AuthResponse login(AuthRequest request);
    public User register(AuthRequest request);
    public AuthResponse renewToken(AuthRequest request);
}
