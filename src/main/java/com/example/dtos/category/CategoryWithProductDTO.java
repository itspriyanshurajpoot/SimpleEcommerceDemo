package com.example.dtos.category;

import com.example.dtos.product.ProductDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryWithProductDTO {

    private Long id;
    private String name;
    private List<ProductDTO> products;
}
