package com.alwis.ecommerce.productcatalogapi.controller;

import com.alwis.ecommerce.productcatalogapi.model.Product;
import com.alwis.ecommerce.productcatalogapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Creating a product
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.createProduct(product);
    }

    // Fetching all products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // Fetching a product by id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "The product " + id + " is deleted successfully!!";
    }

}
