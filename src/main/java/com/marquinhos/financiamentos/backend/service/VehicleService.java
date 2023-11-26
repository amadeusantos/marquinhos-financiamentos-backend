package com.marquinhos.financiamentos.backend.service;

import com.marquinhos.financiamentos.backend.model.*;
import com.marquinhos.financiamentos.backend.repository.VehicleRepository;
import com.marquinhos.financiamentos.backend.util.exceptions.VehicleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public List<Model> filterModels(TypeEnum type, int marcaId, String name) {
        Model[] vehicles = this.models(type, marcaId);
        return Arrays.stream(vehicles)
                .filter((vehicle -> vehicle.getName().toLowerCase().contains(name.toLowerCase()))).toList();
    }

}
