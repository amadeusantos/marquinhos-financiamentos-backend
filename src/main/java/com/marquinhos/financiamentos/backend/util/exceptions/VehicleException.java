package com.marquinhos.financiamentos.backend.util.exceptions;

public class VehicleException extends RuntimeException {

    public VehicleException(String message) {
        super("Error: " + message);
    }

}
