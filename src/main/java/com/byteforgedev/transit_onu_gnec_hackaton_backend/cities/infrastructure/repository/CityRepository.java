package com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.infrastructure.repository;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.entity.City;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findCityByName(String name);
}
