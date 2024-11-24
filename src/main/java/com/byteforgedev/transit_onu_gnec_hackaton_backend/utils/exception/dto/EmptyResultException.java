package com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto;

public class EmptyResultException extends RuntimeException {
    public EmptyResultException(String message) {
        super(message);
    }
}
