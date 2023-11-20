package com.marquinhos.financiamentos.backend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.marquinhos.financiamentos.backend.model.Vehicle;
import com.marquinhos.financiamentos.backend.util.exceptions.VehicleException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {
	
	private String url = "https://parallelum.com.br/fipe/api/v2/";
	
	public Vehicle[] brands(String type) throws VehicleException {
		RestTemplate restTemplate = new RestTemplate();

		if(!checkType(type)){
			throw new VehicleException("This type is not valid");
		}

		String urlMethod = url + type + "/brands";
		Vehicle[] pedido = restTemplate.getForObject(urlMethod, Vehicle[].class);
		return pedido;

	}
	
	public Vehicle[] models(String type, int codigo) {
		RestTemplate restTemplate = new RestTemplate();

		if(!checkType(type)){
			throw new VehicleException("This type is not valid");
		}

		String urlMethod = url +  type + "/brands/" + codigo + "/models";
		Vehicle[] pedido = restTemplate.getForObject(urlMethod, Vehicle[].class);

		return pedido;		
		
	}

	public Vehicle[] years(String type, int brandId, int yearId){
		RestTemplate restTemplate = new RestTemplate();

		if(!checkType(type)){
			throw new VehicleException("This type is not valid");
		}

		String urlMethod = url +  type + "/brands/" + brandId + "/models/" + yearId + "/years";
		Vehicle[] pedido = restTemplate.getForObject(urlMethod, Vehicle[].class);

		return pedido;	

	}

	public boolean checkType(String type){
		List<String> typeList = Arrays.asList("cars", "motorcycles", "trucks");
		return typeList.contains(type);
	}

	
}
