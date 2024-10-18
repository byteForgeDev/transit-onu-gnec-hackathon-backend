package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.services;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.Rol;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<Rol> findById(Long id);

    List<Rol> getAll();
    
    Rol save(Rol role);
}
