package com.example.controllers;

import com.example.dtos.CategoryDTO;
import com.example.dtos.FakeStoreProductDTO;
import com.example.dtos.ProductDTO;
import com.example.services.FakeStoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final FakeStoreService fakeStoreService;

    @GetMapping
    public List<CategoryDTO> getCategories() throws IOException {
        return fakeStoreService.getAllCategory();
    }

    @GetMapping("/category")
    public List<ProductDTO> getAllProductByCategory(@RequestParam String type) throws Exception {
        return fakeStoreService.getAllProductByCategory(type);
    }

    @GetMapping("/product/id/{id}")
    public FakeStoreProductDTO getProductById(@PathVariable int id) throws IOException {
        return fakeStoreService.getAllProductById(id);
    }

}
