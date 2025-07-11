package com.example.controllers;

import com.example.dtos.product.ProductDTO;
import com.example.dtos.product.ProductWithCategoryDTO;
import com.example.services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Tag(name = "Product Controller", description = "Product Controller APIs")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // add product
    @PostMapping("/add-product")
    @Operation(summary = "Add Product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.addProduct(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Product By Id")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @Operation(summary = "Search Product")
    @GetMapping("/search-product")
    public ResponseEntity<List<ProductDTO>> searchProduct(@RequestParam String q){
        return ResponseEntity.ok(productService.searchProduct(q));
    }

    @Operation(summary = "Filter Product By Minimum Price Range")
    @GetMapping("/filter-by-price")
    public ResponseEntity<List<ProductDTO>> filterByPrice(@RequestParam double minPrice){
        return ResponseEntity.ok(productService.searchProductLessThan(minPrice));
    }

    @Operation(summary = "Get All Product")
    @GetMapping("/get-all-product")
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }


    @Operation(summary = "Get Product With Category Details By Id")
    @GetMapping("/product-id/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductWithCategoryById(id));
    }
}
