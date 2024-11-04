package com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityRequest {
    @NotBlank(message = "Please add a name for the city")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String cityName;

    @NotBlank(message = "Please add a name for the country")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String countryName;
}
