package com.example.repository.abstracts;

import com.example.core.abstracts.BaseRepository;
import com.example.entities.concretes.Category;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends BaseRepository<Category,Long> {
    Optional<Category> findByName(String name);
    boolean existsByName(String name);
}
