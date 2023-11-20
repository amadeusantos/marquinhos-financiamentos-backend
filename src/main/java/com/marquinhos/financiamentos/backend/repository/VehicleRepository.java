package com.marquinhos.financiamentos.backend.repository;

import org.springframework.stereotype.Repository;

import com.redis.om.spring.repository.RedisDocumentRepository;

import com.marquinhos.financiamentos.backend.model.Vehicle;

@Repository
public interface VehicleRepository extends RedisDocumentRepository<Vehicle, String> {}
