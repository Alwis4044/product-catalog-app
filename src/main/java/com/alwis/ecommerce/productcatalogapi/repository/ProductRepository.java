package com.alwis.ecommerce.productcatalogapi.repository;

import com.alwis.ecommerce.productcatalogapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
