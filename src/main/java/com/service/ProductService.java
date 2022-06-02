package com.service;


import com.entities.models.ProductModel;

import java.util.List;

public interface ProductService {


    List<ProductModel> getByCategory(Integer id);
    List<ProductModel> getByIds(List<Integer> ids);
}
