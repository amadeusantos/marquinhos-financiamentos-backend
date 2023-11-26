package com.marquinhos.financiamentos.backend.model;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class Vehicle implements Serializable {

    private String price;

    private String brand;

    private String model;

    private int modelYear;

    private String fuel;

    private String codeFipe;

    private String referenceMonth;

    private String fuelAcronym;

}
