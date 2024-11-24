package com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.services;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto.AddressOnlyResponse;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto.LocationOnlyResponse;

public interface GoogleMapsService {
    AddressOnlyResponse getAddressFromCoordinates(double lat, double lng);

    LocationOnlyResponse getCoordinatesFromAddress(String address);
}
