package com.example.gateway;

import com.example.dtos.category.CategoryDTO;
import com.example.dtos.FakeStoreCategoryResponseDto;
import com.example.dtos.FakeStoreProductDTO;
import com.example.dtos.product.ProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreRestTemplateGateway implements IFakeApiGateway{

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public FakeStoreRestTemplateGateway(RestTemplate restTemplate,@Value("{fakeapi.url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {

        String url = baseUrl + "products/category";

        FakeStoreCategoryResponseDto forObject = restTemplate.getForObject(url, FakeStoreCategoryResponseDto.class);
        if (forObject == null) {
            throw new IOException("Failed to fetch categories from Fake Store API");
        }

        return forObject.getCategories()
                .stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }

    @Override
    public List<ProductDTO> getAllProductsByCategory(String category) throws IOException {
        return null;
    }

    @Override
    public FakeStoreProductDTO getAllProductById(int id) throws IOException {
        return null;
    }
}
