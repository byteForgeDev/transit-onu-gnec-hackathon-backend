package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.dto.AuthResponse;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.dto.LoginRequest;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.dto.RegisterRequest;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.Rol;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.User;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.infrastructure.repositories.RoleRepository;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.infrastructure.repositories.UserRepository;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.infrastructure.security.jwt.JwtService;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository; 

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {

        Optional<User> existingUser_name = userRepository.findByUsername(request.getUsername());

        if (!existingUser_name.isPresent()) {
                throw new BusinessException("P-300", HttpStatus.CONFLICT, "The user doesn't exists");
            } 

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);

        // Fetch the user entity
        User userResponse = existingUser_name.get(); 


        return AuthResponse.builder()
                .token(token)
                .id(userResponse.getId()) 
                .username(userResponse.getUsername())
                .email(userResponse.getEmail())
                .build();
    }

    public AuthResponse register(RegisterRequest request) {

        Optional<User> existingUser_username = userRepository.findByUsername(request.getUsername());

        if (existingUser_username.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "The username is already taken");
        } 

        
        List<Rol> roles = request.getRoles().stream()
        .map(roleName -> roleRepository.findByRol(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
        .collect(Collectors.toList());


        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword())) 
                .email(request.getEmail())
                .photoProfileUrl(request.getPhotoProfileUrl())
                .roles(roles) 
                .enabled(true) 
                .audit(new Audit())
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();

    }

}
