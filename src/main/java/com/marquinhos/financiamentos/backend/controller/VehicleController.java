package com.marquinhos.financiamentos.backend.controller;

import com.marquinhos.financiamentos.backend.model.Brand;
import com.marquinhos.financiamentos.backend.model.Model;
import com.marquinhos.financiamentos.backend.model.TypeEnum;
import com.marquinhos.financiamentos.backend.service.VehicleService;
import com.marquinhos.financiamentos.backend.util.exceptions.VehicleException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
@CrossOrigin("*")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> getBrand(@RequestParam TypeEnum type) {
        return ResponseEntity.ok(vehicleService.brands(type));
    }

    @GetMapping("/model")
    public ResponseEntity<?> getModel(@RequestParam TypeEnum type, int brandId) {
        return ResponseEntity.ok(vehicleService.models(type, brandId));
    }

    @GetMapping("/year")
    public ResponseEntity<?> getYear(@RequestParam TypeEnum type, int brandId, int yearId) {
        return ResponseEntity.ok(vehicleService.years(type, brandId, yearId));
    }

    @GetMapping("/model/{type}/")
    public ResponseEntity<List<Brand>> filterBrand(
            @PathVariable TypeEnum type,
            @RequestParam String marca) {
        return ResponseEntity.ok(vehicleService.filterBrands(type, marca));
    }

    @GetMapping("/model/{type}/{marcaId}")
    public ResponseEntity<List<Model>> filterModel(
            @PathVariable TypeEnum type,
            @PathVariable int marcaId,
            @RequestParam String name) {
        return ResponseEntity.ok(vehicleService.filterModels(type, marcaId, name));
    }

}
