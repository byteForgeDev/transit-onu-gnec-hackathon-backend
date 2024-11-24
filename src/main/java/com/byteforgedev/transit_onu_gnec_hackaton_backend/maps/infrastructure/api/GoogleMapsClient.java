package com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.infrastructure.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto.GeocodeResponse;

@Component
public class GoogleMapsClient {
    private final RestTemplate restTemplate;
    private final GoogleMapsConfig googleMapsConfig;

    public GoogleMapsClient(RestTemplate restTemplate, GoogleMapsConfig googleMapsConfig) {
        this.restTemplate = restTemplate;
        this.googleMapsConfig = googleMapsConfig;
    }

    public GeocodeResponse getAddressFromCoordinates(double lat, double lng) {
        String url = String.format(
            "%s?latlng=%f,%f&key=%s",
            googleMapsConfig.getBaseUrl(), lat, lng, googleMapsConfig.getApiKey()
        );

        return restTemplate.getForObject(url, GeocodeResponse.class);
    }

    public GeocodeResponse getCoordinatesFromAddress(String address) {
        String url = String.format(
            "%s?address=%s&key=%s",
            googleMapsConfig.getBaseUrl(),
            address.replace(" ", "+"),
            googleMapsConfig.getApiKey()
        );
        
        return restTemplate.getForObject(url, GeocodeResponse.class);
    }
}
