package com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String code;
    private String message; 
}
