package com.alwis.ecommerce.productcatalogapi.service;

import com.alwis.ecommerce.productcatalogapi.error.ProductNotFoundException;
import com.alwis.ecommerce.productcatalogapi.model.Category;
import com.alwis.ecommerce.productcatalogapi.model.Product;
import com.alwis.ecommerce.productcatalogapi.repository.CategoryRepository;
import com.alwis.ecommerce.productcatalogapi.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product createProduct(Product product) {
        log.info("Saving product: {}",product.getName());
        Long categoryId = product.getCategory().getId();

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));

        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Fetching all products");
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {

        log.info("Fetching product with id:{}",id);
        Optional<Product> product = productRepository.findById(id);

        if(!product.isPresent()){
            throw new ProductNotFoundException("Product not available");
        }

        return product.get();
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        log.info("Deleting product with id:{}",id);

        Optional<Product> product = productRepository.findById(id);

        if(!product.isPresent()){
            throw new ProductNotFoundException("Product not available");
        }
        productRepository.deleteById(id);
    }
}
