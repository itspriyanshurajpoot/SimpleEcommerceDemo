package com.example.dtos.product;


import com.example.dtos.category.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductWithCategoryDTO {
    private Long id;
    private String title;
    private String image;
    private int price;
    private String description;
    private String brand;
    private String model;
    private String color;
    private int discount;
    private boolean onSale;
    private CategoryDTO category;
}
