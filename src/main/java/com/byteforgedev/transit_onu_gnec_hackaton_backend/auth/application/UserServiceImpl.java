package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.User;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.services.UserService;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.infrastructure.repositories.UserRepository;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {

        if (!userRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "The user doesn't exist");
        }

        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {

        if (!userRepository.findByUsername(username).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "The user doesn't exist");
        }

        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND,"The are not user registered");
        }

        return userRepository.findAll();
    }

}
