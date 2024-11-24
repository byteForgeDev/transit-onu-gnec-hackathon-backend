package com.byteforgedev.transit_onu_gnec_hackaton_backend.maps.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationOnlyResponse {
    private double lat;
    private double lng;
}
