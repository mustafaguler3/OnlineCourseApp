package com.example.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.example.business",
		"com.example.core",
		"com.example.webapi",
		"com.example.repository",
		"com.example.entities"
})
@EntityScan(basePackages = "com.example.entities")
@EnableJpaRepositories(basePackages = "com.example.repository")
public class WebapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebapiApplication.class, args);
	}

}
