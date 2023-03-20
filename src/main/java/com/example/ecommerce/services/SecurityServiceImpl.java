package com.example.ecommerce.services;

import com.example.ecommerce.entities.User;
import com.example.ecommerce.repositories.UserRepository;
import com.example.ecommerce.dtos.AuthRequest;
import com.example.ecommerce.dtos.AuthResponse;
import com.example.ecommerce.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SecurityServiceImpl implements  SecurityService {

    @Autowired
    UserRepository repository;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;



    public AuthResponse login(AuthRequest request){

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        String accessToken = jwtUtil.generateAccessToken(user);
        return new AuthResponse(user.getEmail(), accessToken);
    }


    public User register(AuthRequest request) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(request.getPassword());

        User newUser = new User(request.getEmail(), password);

        return repository.save(newUser);
    }
}
