package com.example.mappers;

import com.example.dtos.category.CategoryDTO;
import com.example.dtos.category.CategoryWithProductDTO;
import com.example.entities.Category;

import java.util.List;

public class CategoryMapper {

    public static CategoryDTO toDto(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }


    public static Category toEntity(CategoryDTO dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }

    public static CategoryWithProductDTO  toCategoryWithProductDTO(Category category){
        return CategoryWithProductDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .products(category.getProducts()
                        .stream()
                        .map(ProductMapper::toDto)
                        .toList())
                .build();
    }
}
