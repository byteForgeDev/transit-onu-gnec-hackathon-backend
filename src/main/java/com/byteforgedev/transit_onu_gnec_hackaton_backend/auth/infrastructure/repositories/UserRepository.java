package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
