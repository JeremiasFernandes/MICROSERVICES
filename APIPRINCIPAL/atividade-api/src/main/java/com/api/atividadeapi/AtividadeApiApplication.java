package com.api.atividadeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.web.bind.annotation.RestController;


@EntityScan(basePackages = "com.api.atividadeapi.models")
@SpringBootApplication
@RestController

public class AtividadeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeApiApplication.class, args);
	}


}
