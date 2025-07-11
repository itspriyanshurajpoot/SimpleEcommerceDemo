package com.example.services.impl;

import com.example.dtos.category.CategoryDTO;
import com.example.dtos.category.CategoryWithProductDTO;
import com.example.entities.Category;
import com.example.mappers.CategoryMapper;
import com.example.repositories.CategoryRepository;
import com.example.services.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO dto) {

        Category category = categoryRepository.findByNameIgnoreCase(dto.getName())
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(dto.getName());
                    return categoryRepository.save(newCategory);
                });

        return CategoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .toList();
    }

    @Override
    public CategoryWithProductDTO getAllProductOfACategory(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toCategoryWithProductDTO)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
}
