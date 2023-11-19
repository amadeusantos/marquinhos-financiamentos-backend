package com.marquinhos.financiamentos.backend.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Vehicle")
public class Vehicle implements Serializable {

    private String id;
}
