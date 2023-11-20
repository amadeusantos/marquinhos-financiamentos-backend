package com.marquinhos.financiamentos.backend.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;

@RedisHash("Vehicle")
@Getter
public class Vehicle implements Serializable {

    private String name;
    private String code;
}
