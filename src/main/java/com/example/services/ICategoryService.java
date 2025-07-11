package com.example.services;

import com.example.dtos.category.CategoryDTO;
import com.example.dtos.category.CategoryWithProductDTO;

import java.util.List;

public interface ICategoryService {

    // add category
    CategoryDTO addCategory(CategoryDTO dto);

    // Get All Category
    List<CategoryDTO> getAllCategory();

    CategoryWithProductDTO getAllProductOfACategory(Long id);
}
