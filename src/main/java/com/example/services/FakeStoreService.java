package com.example.services;

import com.example.dtos.CategoryDTO;
import com.example.dtos.FakeStoreProductDTO;
import com.example.dtos.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface FakeStoreService {

    List<CategoryDTO> getAllCategory() throws IOException;
    List<ProductDTO> getAllProductByCategory(String categoryType) throws IOException;

    FakeStoreProductDTO getAllProductById(int id) throws IOException;
}
