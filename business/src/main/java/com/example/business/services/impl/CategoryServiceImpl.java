package com.example.business.services.impl;

import com.example.business.services.CategoryService;
import com.example.core.dtos.CategoryDto;
import com.example.business.mappings.CategoryMapper;
import com.example.entities.concretes.Category;
import com.example.repository.abstracts.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();

        if (categories.isEmpty()){
            return List.of();
        }
        return categoryMapper.toDtoList(categories);
    }
}
