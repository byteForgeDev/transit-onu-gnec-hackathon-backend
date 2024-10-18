package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.services;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);
    
    List<User> getAll();

    Optional<User> findByUsername(String username);

}
