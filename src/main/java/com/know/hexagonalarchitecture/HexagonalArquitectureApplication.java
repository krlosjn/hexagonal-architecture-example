package com.know.hexagonalarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.know"})
@SpringBootApplication
public class HexagonalArquitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArquitectureApplication.class, args);
	}

}

