package com.example.services;

import com.example.dtos.CategoryDTO;
import com.example.dtos.FakeStoreProductDTO;
import com.example.dtos.ProductDTO;
import com.example.gateway.IFakeApiGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class FakeStoreServiceImpl implements FakeStoreService{

    private final IFakeApiGateway fakeApiGateway;

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        return fakeApiGateway.getAllCategory();
    }

    @Override
    public List<ProductDTO> getAllProductByCategory(String categoryType) throws IOException {
        return fakeApiGateway.getAllProductsByCategory(categoryType);
    }

    @Override
    public FakeStoreProductDTO getAllProductById(int id) throws IOException {
        return fakeApiGateway.getAllProductById(id);
    }
}
