package com.example.dtos;

import com.example.dtos.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FakeStoreProductDTO {

    private String status;
    private String message;
    private List<ProductDTO> products;
    private ProductDTO product;
}
