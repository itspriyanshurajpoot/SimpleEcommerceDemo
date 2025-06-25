package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public String getCategories() {
        return "Get : [\"Electronics\", \"Books\", \"Clothing\"]";
    }

    @GetMapping("/details")
    public String postCategory() {
        return "Post : {\"Electronics\": \"Devices and gadgets\", \"Books\": \"Printed and digital books\", \"Clothing\": \"Apparel and accessories\"}";
    }

    @GetMapping("/count")
    public String getCategoryCount() {
        return "{\"count\": 3}";
    }

}
