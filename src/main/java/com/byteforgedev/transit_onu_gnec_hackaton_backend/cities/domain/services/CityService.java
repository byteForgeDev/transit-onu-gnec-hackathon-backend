package com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.services;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.dto.CityRequest;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.entity.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    Optional<City> findByName(String name);

    List<City> getAll();
    
    City save(CityRequest request);
}
