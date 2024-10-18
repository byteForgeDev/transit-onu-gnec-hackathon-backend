package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRol(String rol); 
}
