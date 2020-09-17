package com.viewnext.autoriego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan
@EnableAsync
@EnableSwagger2
public class AutoriegoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoriegoApplication.class, args);
	}

}
