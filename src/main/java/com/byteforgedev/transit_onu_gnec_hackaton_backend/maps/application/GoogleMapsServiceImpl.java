package com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto.AddressOnlyResponse;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto.GeocodeResponse;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto.LocationOnlyResponse;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.services.GoogleMapsService;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.infrastructure.api.GoogleMapsClient;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto.EmptyResultException;

@Service
public class GoogleMapsServiceImpl implements GoogleMapsService {

    @Autowired
    private final GoogleMapsClient googleMapsClient;

    public GoogleMapsServiceImpl(GoogleMapsClient googleMapsClient) {
        this.googleMapsClient = googleMapsClient;
    }

    @Override
    public AddressOnlyResponse getAddressFromCoordinates(double lat, double lng) {
        GeocodeResponse fullResponse = googleMapsClient.getAddressFromCoordinates(lat, lng);

        // Extract the first formatted_address
        String formattedAddress = fullResponse.getResults()
            .get(0)
            .getFormatted_address();

        return AddressOnlyResponse.builder()
            .formatted_address(formattedAddress)
            .build();
    }

    @Override
    public LocationOnlyResponse getCoordinatesFromAddress(String address) {

        if (address.isEmpty()) {
            throw new EmptyResultException("Imposible to convert a empty address to coordinates.");
        }

        GeocodeResponse fullResponse = googleMapsClient.getCoordinatesFromAddress(address);

        // Check if the response contains results
        if (fullResponse.getResults().isEmpty()) {
            throw new EmptyResultException("No results found for the provided address: " + address);
        }

        // Extract the first location (latitude and longitude) from the response
        GeocodeResponse.Location location = fullResponse.getResults()
        .get(0) 
        .getGeometry() 
        .getLocation(); 

        // Map the extracted location to a LocationOnlyResponse DTO
        return LocationOnlyResponse.builder()
            .lat(location.getLat())
            .lng(location.getLng())
            .build();
    }
}