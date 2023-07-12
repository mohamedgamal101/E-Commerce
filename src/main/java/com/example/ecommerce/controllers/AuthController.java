package com.example.ecommerce.controllers;

import javax.validation.Valid;

import com.example.ecommerce.dtos.AuthRequest;
import com.example.ecommerce.dtos.AuthResponse;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    SecurityService securityService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            AuthResponse response = securityService.login(request);
            return ResponseEntity.ok().body(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid AuthRequest request) {
        User registeredUser = securityService.register(request);
        return ResponseEntity.ok().body(String.format("User registered with email [%s]. Please try to login.", request.getEmail()));
    }

    @PostMapping("renew")
    public ResponseEntity<?> renew(@RequestBody @Valid AuthRequest request) {
        try {
            AuthResponse response = securityService.renewToken(request);
            return ResponseEntity.ok().body(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}