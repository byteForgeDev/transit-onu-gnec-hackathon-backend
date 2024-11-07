package com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.domain.entity.Country;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.domain.services.CountryService;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.infrastructure.repository.CountryRepository;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Optional<Country> findByName(String name) {
         if (!countryRepository.findCountryByName(name).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "The country doesn't exist");
        }

        return countryRepository.findCountryByName(name);
    }

    @Override
    public List<Country> getAll() {
        List<Country> countries = countryRepository.findAll();

        if (countries.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "There are not countries registered");
        }

        return countries;
    }

    @Override
    public Country save(Country country) {
        Optional<Country> existingCountry = countryRepository.findCountryByName(country.getName());

        if (existingCountry.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "The country already exists");
        }

        return countryRepository.save(country);
    }

}