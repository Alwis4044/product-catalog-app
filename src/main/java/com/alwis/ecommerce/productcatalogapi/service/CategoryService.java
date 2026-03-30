package com.alwis.ecommerce.productcatalogapi.service;


import com.alwis.ecommerce.productcatalogapi.error.CategoryNotFoundException;
import com.alwis.ecommerce.productcatalogapi.model.Category;
import jakarta.validation.Valid;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id) throws CategoryNotFoundException;
    void deleteCategory(Long id) throws CategoryNotFoundException;

    Category updateCategory(Long id,Category categoryDetails);
}
