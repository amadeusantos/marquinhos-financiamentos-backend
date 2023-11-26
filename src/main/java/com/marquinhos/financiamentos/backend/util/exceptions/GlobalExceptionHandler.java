package com.marquinhos.financiamentos.backend.util.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VehicleException.class)
    public ResponseEntity<ExceptionResponse> handleGenericVehicleException(VehicleException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(FinancingException.class)
    public ResponseEntity<ExceptionResponse> handleGenericFinancingException(FinancingException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage()));
  
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentTypeMismatchException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse("Accepted types are CARS, MOTORCYCLES and TRUCKS"));
    }

}
