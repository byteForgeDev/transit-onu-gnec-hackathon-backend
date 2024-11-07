package com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.infrastructure.repository;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.domain.entity.Country;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findCountryByName(String name);
}
