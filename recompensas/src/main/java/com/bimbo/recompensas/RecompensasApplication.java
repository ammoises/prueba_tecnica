package com.bimbo.recompensas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//public class RecompensasApplication extends SpringBootServletInitializer {
public class RecompensasApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RecompensasApplication.class, args);
	}

	/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RecompensasApplication.class);
	}
	*/
}
