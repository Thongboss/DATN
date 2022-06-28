package com.service;

import com.entities.Product;
import com.entities.dtos.ProductDto;
import com.entities.models.ProductModel;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IBaseService<Product, ProductModel, Long> {
    List<ProductDto> getAllByCategory(Long categoryId);
    
    List<Product> findByNameContaining(String name);

    Page<Product> findByNameContaining(String name, Pageable page);
}
