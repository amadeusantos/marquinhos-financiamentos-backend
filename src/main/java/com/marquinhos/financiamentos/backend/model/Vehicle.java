package com.marquinhos.financiamentos.backend.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Vehicle")
public class Vehicle implements Serializable {

    private String id;
}
