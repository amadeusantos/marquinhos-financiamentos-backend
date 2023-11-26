package com.marquinhos.financiamentos.backend.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;

@Getter
public class Vehicle implements Serializable {

    @Id
    private String code;

    private String name;

}
