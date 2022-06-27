package com.repository;

import com.entities.dtos.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    @Query("select new com.entities.dtos.ProductDto(entity) from Product entity where entity.category.categoryId=?1")
    List<ProductDto> getAllByCategory(Long categoryId);
}
