package com.example.hw8_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2

@SpringBootApplication
public class Hw8BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw8BackendApplication.class, args);
	}

}
