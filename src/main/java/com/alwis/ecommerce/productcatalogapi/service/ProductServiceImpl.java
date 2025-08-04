package com.alwis.ecommerce.productcatalogapi.service;

import com.alwis.ecommerce.productcatalogapi.error.ProductNotFoundException;
import com.alwis.ecommerce.productcatalogapi.model.Category;
import com.alwis.ecommerce.productcatalogapi.model.Product;
import com.alwis.ecommerce.productcatalogapi.repository.CategoryRepository;
import com.alwis.ecommerce.productcatalogapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product createProduct(Product product) {
        Long categoryId = product.getCategory().getId();

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));

        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);

        if(!product.isPresent()){
            throw new ProductNotFoundException("Product not available");
        }

        return product.get();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
