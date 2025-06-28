package com.example.gateway;

import com.example.dtos.CategoryDTO;
import com.example.dtos.FakeStoreProductDTO;
import com.example.dtos.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IFakeApiGateway {

    List<CategoryDTO> getAllCategory() throws IOException;
    List<ProductDTO> getAllProductsByCategory(String category) throws IOException;

    FakeStoreProductDTO getAllProductById(int id) throws IOException;
}
