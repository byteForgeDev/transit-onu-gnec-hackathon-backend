package com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.application.GoogleMapsServiceImpl;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto.AddressOnlyResponse;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto.GeocodeRequest;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto.LocationOnlyResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/api/maps")
public class GoogleMapsController {

    private final GoogleMapsServiceImpl googleMapsServiceImpl;

    public GoogleMapsController(GoogleMapsServiceImpl googleMapsServiceImpl) {
        this.googleMapsServiceImpl = googleMapsServiceImpl;
    }

    @Operation(
        summary = "Get Address from Coordinates",
        description = "Convert geographic coordinates (latitude and longitude) into a human-readable address.",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody( // Fully qualified Swagger RequestBody
            description = "Coordinates to reverse geocode",
            required = true,
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    value = """
                    {
                        "lat": 37.4220656,
                        "lng": -122.0840897
                    }
                    """
                )
            )
        )
    )
    @PostMapping("/coordinates")
    public ResponseEntity<AddressOnlyResponse> getAddressFromCoordinates(
        @RequestBody GeocodeRequest request) {
                return ResponseEntity.ok(googleMapsServiceImpl.getAddressFromCoordinates(request.getLat(), request.getLng()));
            }

    @Operation(
        summary = "Get Coordinates from Address",
        description = "Convert a human-readable address into geographic coordinates (latitude and longitude).",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody( // Fully qualified Swagger RequestBody
            description = "Address to geocode",
            required = true,
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    value = """
                    {
                        "address": "1600 Amphitheatre Parkway, Mountain View, CA"
                    }
                    """
                )
            )
        ),
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Coordinates retrieved successfully",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                        value = """
                        {
                            "lat": 37.4220656,
                            "lng": -122.0840897
                        }
                        """
                    )
                )
            )
        }
    )
    @PostMapping("/address")
    public ResponseEntity<LocationOnlyResponse> getCoordinatesFromAddress(@RequestBody GeocodeRequest request) {
        return ResponseEntity.ok(googleMapsServiceImpl.getCoordinatesFromAddress(request.getAddress()));
    }
}
