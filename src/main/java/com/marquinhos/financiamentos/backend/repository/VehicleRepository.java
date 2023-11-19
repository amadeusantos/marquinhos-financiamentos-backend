package com.marquinhos.financiamentos.backend.repository;

import com.marquinhos.financiamentos.backend.model.Vehicle;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends RedisDocumentRepository<Vehicle, String> {}
