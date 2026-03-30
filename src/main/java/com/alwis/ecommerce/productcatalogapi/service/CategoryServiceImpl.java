package com.alwis.ecommerce.productcatalogapi.service;

import com.alwis.ecommerce.productcatalogapi.error.CategoryNotFoundException;
import com.alwis.ecommerce.productcatalogapi.model.Category;
import com.alwis.ecommerce.productcatalogapi.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category createCategory(Category category) {
        log.info("Saving category: {}",category.getName());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {

        log.info("Fetching all categories");
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {

         log.info("Fetching category with id: {}",id);
         Optional<Category> category = categoryRepository.findById(id);

         if(!category.isPresent()){
             throw new CategoryNotFoundException("Category not available");
         }

         return category.get();
    }

    @Override
    public void deleteCategory(Long id) throws CategoryNotFoundException {

        log.info("Deleting category with id:{}",id);
        Optional<Category> category = categoryRepository.findById(id);

        if(!category.isPresent()){
            throw new CategoryNotFoundException("Category not available");
        }

        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) {

        Category categoryDB = categoryRepository.findById(id).get();

        if(Objects.nonNull(categoryDetails.getName()) && !"".equalsIgnoreCase(categoryDetails.getName())){
            categoryDB.setName(categoryDetails.getName());
        }

        if(Objects.nonNull(categoryDetails.getDescription()) && !"".equalsIgnoreCase(categoryDetails.getDescription())){
            categoryDB.setDescription((categoryDetails.getDescription()));
        }

        return categoryRepository.save(categoryDB);
    }
}
