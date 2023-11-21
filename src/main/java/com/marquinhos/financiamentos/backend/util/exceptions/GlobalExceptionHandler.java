package com.marquinhos.financiamentos.backend.util.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VehicleException.class)
    public ResponseEntity<ExceptionResponse> handleGenericVehicleException(VehicleException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(FinancingException.class)
    public ResponseEntity<ExceptionResponse> handleGenericFinancingException(FinancingException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage()));
    }

}
