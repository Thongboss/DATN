package com.service;

import com.entities.Category;
import com.entities.dtos.CategoryDto;
import com.entities.models.CategoryModel;

import java.util.List;

public interface ICategoryService extends IBaseService<Category, CategoryModel, Long> {
    List<CategoryDto> getAll();
}
