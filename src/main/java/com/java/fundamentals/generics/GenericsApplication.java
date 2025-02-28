package com.java.fundamentals.generics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.java.fundamentals.generics")
@EnableJpaRepositories("com.java.fundamentals.generics.repository")
@EntityScan("com.java.fundamentals.generics.entity")
public class GenericsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericsApplication.class, args);
	}

}
