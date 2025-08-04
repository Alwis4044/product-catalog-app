package com.alwis.ecommerce.productcatalogapi.controller;


import com.alwis.ecommerce.productcatalogapi.error.CategoryNotFoundException;
import com.alwis.ecommerce.productcatalogapi.model.Category;
import com.alwis.ecommerce.productcatalogapi.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Create Category
    @PostMapping
    public Category createCategory(@Valid @RequestBody Category category){
        return categoryService.createCategory(category);
    }

    // Get All Categories
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    // Get Category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) throws CategoryNotFoundException {

        return categoryService.getCategoryById(id);
    }

    // Delete Category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return "The category " + id + " is deleted successfully!!";
    }
}
