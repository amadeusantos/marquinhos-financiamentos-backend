package com.marquinhos.financiamentos.backend.repository;

import com.marquinhos.financiamentos.backend.model.*;
import com.marquinhos.financiamentos.backend.util.exceptions.NotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class VehicleRepository {

    private static final String URL = "https://parallelum.com.br/fipe/api/v2/";

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable("Brands")
    public Brand[] getBrands(TypeEnum type) {
        try {
            restTemplate.getErrorHandler();
            String urlMethod = URL + type.name().toLowerCase() + "/brands";
            return restTemplate.getForObject(urlMethod, Brand[].class);
        } catch (Exception e) {
            return new Brand[0];
        }

        }

    @Cacheable("Models")
    public Model[] getModels(TypeEnum type, int brandId) {
        try {
            String urlMethod = URL + type.name().toLowerCase() + "/brands/" + brandId + "/models";
            return restTemplate.getForObject(urlMethod, Model[].class);
        } catch (Exception e) {
            return new Model[0];
        }
    }

    @Cacheable("Years")
    public Year[] getYears(TypeEnum type, int brandId, int yearId) {
        try {
            String urlMethod = URL + type.name().toLowerCase() + "/brands/" + brandId + "/models/" + yearId + "/years";
            return restTemplate.getForObject(urlMethod, Year[].class);
        } catch (Exception e) {
            return new Year[0];
        }

    }

    public Vehicle findVehicle(TypeEnum type, int brandId, int modelId, String year) {
        try {
            String urlMethod = URL + type.name().toLowerCase() + "/brands/" + brandId + "/models/" + modelId + "/years/" + year;
            return restTemplate.getForObject(urlMethod, Vehicle.class);
        } catch (Exception e) {
            throw new NotFoundException("Vehicle not found");
        }
    }
}
