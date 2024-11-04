package com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.dto.CityRequest;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.entity.City;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.services.CityService;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.infrastructure.repository.CityRepository;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.domain.entity.Country;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.infrastructure.repository.CountryRepository;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Optional<City> findByName(String name) {
         if (!cityRepository.findCityByName(name).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "The city doesn't exist");
        }

        return cityRepository.findCityByName(name);
    }

    @Override
    public List<City> getAll() {
        List<City> cities = cityRepository.findAll();

        if (cities.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "There are not cities registered");
        }

        return cities;
    }

    @Override
    public City save(CityRequest request) {
        Optional<City> existingCity = cityRepository.findCityByName(request.getCityName());

        if (existingCity.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "The city already exists");
        }

        Optional<Country> existingCountry = countryRepository.findCountryByName(request.getCountryName());
        Country country;
        if (!existingCountry.isPresent()) {
            Country newCountry = Country.builder()
                                .name(request.getCountryName())
                                .build();
            country = countryRepository.save(newCountry);
        } else{
            country = existingCountry.get();
        }
        System.out.println(country.toString());
        City city = City.builder()
                    .name(request.getCityName())
                    .country(country)
                    .build();

        return cityRepository.save(city);
    }

}
