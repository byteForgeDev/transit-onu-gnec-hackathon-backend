package com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto.BusinessException;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto.EmptyResultException;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.exception.dto.ErrorDto;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorDto> businessHandlerException(BusinessException be){
        ErrorDto error = ErrorDto.builder().code(be.getCode()).message(be.getMessage()).build();
        return new ResponseEntity<>(error, be.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->{
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(value = EmptyResultException.class)
    public ResponseEntity<Map<String, Object>> handleEmptyResult(EmptyResultException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage()); // Error message
        errorResponse.put("status", HttpStatus.NOT_FOUND.value()); // HTTP status code

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
