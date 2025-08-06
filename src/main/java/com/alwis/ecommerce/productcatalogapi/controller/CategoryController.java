package com.alwis.ecommerce.productcatalogapi.controller;


import com.alwis.ecommerce.productcatalogapi.error.CategoryNotFoundException;
import com.alwis.ecommerce.productcatalogapi.model.Category;
import com.alwis.ecommerce.productcatalogapi.service.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Create Category
    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){
        log.info("POST /categories - Creating category with name: {}",category.getName());
        Category savedCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    // Get All Categories
    @GetMapping
    public List<Category> getAllCategories(){
        log.info("GET /categories - Fetching all categories");
        return categoryService.getAllCategories();
    }

    // Get Category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) throws CategoryNotFoundException {
        log.info("GET /categories - Fetching category with id: {}", id);
        return categoryService.getCategoryById(id);
    }

    // Delete Category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) throws CategoryNotFoundException {
        log.info("DELETE /categories - Deleting category with id: {}",id);
        categoryService.deleteCategory(id);
        return "The category " + id + " is deleted successfully!!";
    }
}
