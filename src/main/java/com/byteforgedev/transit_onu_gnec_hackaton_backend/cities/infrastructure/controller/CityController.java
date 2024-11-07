package com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.dto.CityRequest;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.entity.City;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.services.CityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> listCities() {
        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    } 

    @GetMapping("/{name}")
    public ResponseEntity<City> showCity(@PathVariable String name){
        return cityService.findByName(name)
            .map(city -> new ResponseEntity<>(city, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<City> saveCity(@Valid @RequestBody CityRequest request) {
        City newCity = cityService.save(request);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }
}
