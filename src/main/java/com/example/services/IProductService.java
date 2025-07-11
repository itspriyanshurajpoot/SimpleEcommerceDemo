package com.example.services;

import com.example.dtos.product.ProductDTO;
import com.example.dtos.product.ProductWithCategoryDTO;

import java.util.List;

public interface IProductService {

    // add product
    ProductDTO addProduct(ProductDTO dto);

    // get product by id
    ProductDTO getProductById(Long id);


    // get product with category by id
    ProductWithCategoryDTO getProductWithCategoryById(Long id);


    // search product
    List<ProductDTO> searchProduct(String keyword);


    // search product having price less than given price
    List<ProductDTO> searchProductLessThan(double minPrice);

    // Get All Product
    List<ProductDTO> getAllProduct();



}
