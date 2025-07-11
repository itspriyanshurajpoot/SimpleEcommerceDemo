package com.example.controllers;

import com.example.dtos.category.CategoryDTO;
import com.example.dtos.category.CategoryWithProductDTO;
import com.example.services.FakeStoreService;
import com.example.services.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final FakeStoreService fakeStoreService;
    private final ICategoryService categoryService;

    @PostMapping
    @Operation(summary = "Add Category")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO dto){
        return ResponseEntity.ok(categoryService.addCategory(dto));
    }

    @Operation(summary = "Get All Category")
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @Operation(summary = "Get Category by Id with all products")
    @GetMapping("/category/{id}/details")
    public ResponseEntity<CategoryWithProductDTO> getAllProductsOfACategory(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getAllProductOfACategory(id));
    }

}
