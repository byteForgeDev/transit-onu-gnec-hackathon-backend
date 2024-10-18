package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.application.AuthServiceImpl;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.dto.AuthResponse;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.dto.LoginRequest;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.dto.RegisterRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authAdapter;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(authAdapter.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authAdapter.register(request));
    }
}
