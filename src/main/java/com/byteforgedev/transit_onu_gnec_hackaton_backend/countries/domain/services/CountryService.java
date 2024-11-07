package com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.domain.services;

import java.util.List;
import java.util.Optional;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.domain.entity.Country;

public interface CountryService {
    Optional<Country> findByName(String name);

    List<Country> getAll();
    
    Country save(Country Country);
}
