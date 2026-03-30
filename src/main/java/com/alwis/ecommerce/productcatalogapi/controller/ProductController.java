package com.alwis.ecommerce.productcatalogapi.controller;

import com.alwis.ecommerce.productcatalogapi.error.ProductNotFoundException;
import com.alwis.ecommerce.productcatalogapi.model.Product;
import com.alwis.ecommerce.productcatalogapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Creating a product
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        log.info("POST /products - Creating product with name: {}",product.getName());
        log.info("POST/ products - Creating product under category with id: {}",product.getCategory().getId());
        return productService.createProduct(product);

    }

    // Fetching all products
    @GetMapping
    public List<Product> getAllProducts(){
        log.info("GET /products - Fetching all products");
        return productService.getAllProducts();
    }

    // Fetching a product by id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        log.info("GET /products - Fetching the product with id:{}",id);
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        log.info("DELETE /products - Deleting product with id: {}",id);
        productService.deleteProduct(id);
        return "The product " + id + " is deleted successfully!!";
    }

}
