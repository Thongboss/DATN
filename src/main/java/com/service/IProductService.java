package com.service;

import com.entities.Product;
import com.entities.dtos.ProductDto;
import com.entities.models.ProductModel;

import java.util.List;

public interface IProductService extends IBaseService<Product, ProductModel, Long> {
    List<ProductDto> getAllByCategory(Long categoryId);
}
