package com.example.services.impl;

import com.example.dtos.product.ProductDTO;
import com.example.dtos.product.ProductWithCategoryDTO;
import com.example.entities.Category;
import com.example.entities.Product;
import com.example.mappers.ProductMapper;
import com.example.repositories.CategoryRepository;
import com.example.repositories.ProductRepository;
import com.example.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public ProductDTO addProduct(ProductDTO dto) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with category id " + dto.getCategoryId()));

        Product product = ProductMapper.toEntity(dto, category);
        return ProductMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategoryById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toProductWithCategoryDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<ProductDTO> searchProduct(String keyword) {
        return productRepository.searchProduct(keyword).stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    @Override
    public List<ProductDTO> searchProductLessThan(double minPrice) {
        return productRepository.searchProductLessThan(minPrice)
                .stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .toList();
    }


}
