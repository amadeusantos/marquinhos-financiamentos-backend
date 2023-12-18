package com.marquinhos.financiamentos.backend.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@RedisHash("Financing")
public class Financing implements Serializable {
  private double installmentsValue;
  private double finalAmount;
}
