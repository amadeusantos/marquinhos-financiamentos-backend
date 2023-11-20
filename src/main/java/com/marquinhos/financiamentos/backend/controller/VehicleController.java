package com.marquinhos.financiamentos.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marquinhos.financiamentos.backend.service.VehicleService;
import com.marquinhos.financiamentos.backend.util.exceptions.VehicleException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> getBrand(@RequestParam String type){
        try{
            return ResponseEntity.ok(vehicleService.brands(type));
        } catch(VehicleException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/model")
    public ResponseEntity<?> getModel(@RequestParam String type, int brandId){
        try{
            return ResponseEntity.ok(vehicleService.models(type, brandId));
        } catch(VehicleException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/year")
    public ResponseEntity<?> getYear(@RequestParam String type, int brandId, int yearId){
        try{
            return ResponseEntity.ok(vehicleService.years(type, brandId, yearId));
        } catch(VehicleException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
