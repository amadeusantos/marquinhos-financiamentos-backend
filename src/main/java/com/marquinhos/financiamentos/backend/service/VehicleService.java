package com.marquinhos.financiamentos.backend.service;

import com.marquinhos.financiamentos.backend.model.*;
import com.marquinhos.financiamentos.backend.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Brand[] brands(TypeEnum type) {
        return vehicleRepository.getBrands(type);
    }

    public Model[] models(TypeEnum type, int codigo) {

        return vehicleRepository.getModels(type, codigo);

    }

    public Year[] years(TypeEnum type, int brandId, int yearId) {
        return vehicleRepository.getYears(type, brandId, yearId);

    }

    public List<Brand> filterBrands(TypeEnum type, String marca) {
        Brand[] vehiclesBrands = brands(type);
        return Arrays.stream(vehiclesBrands)
                .filter((brand -> brand.getName().toLowerCase().contains(marca.toLowerCase()))).toList();
    }

    public List<Model> filterModels(TypeEnum type, int marcaId, String name) {
        Model[] vehiclesModels = this.models(type, marcaId);
        return Arrays.stream(vehiclesModels)
                .filter((model -> model.getName().toLowerCase().contains(name.toLowerCase()))).toList();
    }


    public Vehicle findVehicle(TypeEnum type, int brandId, int modelId, String year) {
        return vehicleRepository.findVehicle(type, brandId, modelId, year);
    }
}
