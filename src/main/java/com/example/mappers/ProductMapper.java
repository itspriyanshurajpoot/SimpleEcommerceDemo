package com.example.mappers;

import com.example.dtos.product.ProductDTO;
import com.example.dtos.product.ProductWithCategoryDTO;
import com.example.entities.Category;
import com.example.entities.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .brand(product.getBrand())
                .price(product.getPrice())
                .description(product.getDescription())
                .color(product.getColor())
                .categoryId(product.getCategory().getId())
                .model(product.getModel())
                .title(product.getTitle())
                .onSale(product.isOnSale())
                .discount(product.getDiscount())
                .build();
    }

    public static Product toEntity(ProductDTO dto, Category category){
        return Product.builder()
                .image(dto.getImage())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .color(dto.getColor())
                .category(category)
                .model(dto.getModel())
                .title(dto.getTitle())
                .onSale(dto.isOnSale())
                .discount(dto.getDiscount())
                .build();
    }


    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product){
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .brand(product.getBrand())
                .price(product.getPrice())
                .description(product.getDescription())
                .color(product.getColor())
                .model(product.getModel())
                .title(product.getTitle())
                .onSale(product.isOnSale())
                .discount(product.getDiscount())
                .category(CategoryMapper.toDto(product.getCategory()))
                .build();
    }
}
