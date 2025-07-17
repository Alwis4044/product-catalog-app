package com.alwis.ecommerce.productcatalogapi.repository;

import com.alwis.ecommerce.productcatalogapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
