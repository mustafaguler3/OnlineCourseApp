package com.example.business.services;

import com.example.core.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();
}
