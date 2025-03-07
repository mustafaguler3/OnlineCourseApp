package com.example.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.example.entities.concretes")
@EnableJpaRepositories(basePackages = "com.example.repository")
public class RepositoryConfig {
}
