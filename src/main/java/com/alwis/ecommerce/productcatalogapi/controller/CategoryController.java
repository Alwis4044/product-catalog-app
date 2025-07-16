package com.alwis.ecommerce.productcatalogapi.controller;

import com.alwis.ecommerce.productcatalogapi.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryController {

    @Id
    private Long id;
    private String name;
    private List<Product> products;
}
