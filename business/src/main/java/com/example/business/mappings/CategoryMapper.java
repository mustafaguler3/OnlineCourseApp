package com.example.business.mappings;

import com.example.core.dtos.CategoryDto;
import com.example.entities.concretes.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtoList(List<Category> categoryList);
    List<Category> toEntityList(List<CategoryDto> categoryDtoList);
}
