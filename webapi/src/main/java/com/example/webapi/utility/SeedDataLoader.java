package com.example.webapi.utility;

import com.example.entities.concretes.Category;
import com.example.repository.abstracts.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class SeedDataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public SeedDataLoader(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<Category> categories = List.of(
                    new Category("Java", "/images/java.png"),
                    new Category("Angular", "/images/angular.png"),
                    new Category("C#", "/images/csharp.png"),
                    new Category("React", "/images/react.png"),
                    new Category("Spring Boot", "/images/spring-boot.png"),
                    new Category("Docker", "/images/docker.png"),
                    new Category("Swift", "/images/swift.png")
            );
            categoryRepository.saveAll(categories);
            System.out.println("Default categories loaded!");
        }
    }
}
