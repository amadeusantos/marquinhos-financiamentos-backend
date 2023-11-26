package com.marquinhos.financiamentos.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MarquinhosFinanciamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarquinhosFinanciamentosApplication.class, args);
	}

}
