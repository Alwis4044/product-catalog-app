package com.alwis.ecommerce.productcatalogapi.service;


import com.alwis.ecommerce.productcatalogapi.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    void deleteCategory(Long id);
}
