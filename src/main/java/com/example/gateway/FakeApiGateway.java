package com.example.gateway;

import com.example.dtos.category.CategoryDTO;
import com.example.dtos.FakeStoreCategoryResponseDto;
import com.example.dtos.FakeStoreProductDTO;
import com.example.dtos.product.ProductDTO;
import com.example.gateway.apis.FakeStoreApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Component
public class FakeApiGateway implements IFakeApiGateway{

    private final FakeStoreApi fakeStoreApi;

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {

        FakeStoreCategoryResponseDto responseDto = this.fakeStoreApi.getAllFakeStoreCategories().execute().body();

        if (responseDto == null){
            throw new IOException("Failed to fetch categories from Fake Store API");
        }

        return responseDto.getCategories()
                .stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }

    @Override
    public List<ProductDTO> getAllProductsByCategory(String category) throws IOException {
        FakeStoreProductDTO responseDTO = this.fakeStoreApi.getAllFakeStoreProductsByCategory(category).execute().body();
        if(responseDTO == null){
            throw new IOException("Failed to fetch product from fake store api");
        }

        return responseDTO
                .getProducts()
                .stream()
                .map(product -> ProductDTO.builder()
                        .title(product.getTitle())
                        .id(product.getId())
                        .model(product.getModel())
                        .price(product.getPrice())
                        .image(product.getImage())
                        .category(product.getCategory())
                        .brand(product.getBrand())
                        .color(product.getColor())
                        .discount(product.getDiscount())
                        .onSale(product.isOnSale())
                        .build())
                .toList();
    }

    @Override
    public FakeStoreProductDTO getAllProductById(int id) throws IOException {

        FakeStoreProductDTO productDTO = this.fakeStoreApi.getAllProductById(id).execute().body();

        System.out.println(productDTO);
        if(productDTO == null){
            throw new IOException("Failed to fetch product from fake store api");
        }

        return productDTO;

//        return productDTO.getProducts()
//                .stream()
//                .map(product -> ProductDTO.builder()
//                        .brand(product.getBrand())
//                        .image(product.getImage())
//                        .model(product.getModel())
//                        .price(product.getPrice())
//                        .category(product.getCategory())
//                        .color(product.getColor())
//                        .description(product.getDescription())
//                        .build())
//                .toList();
    }
}
