package com.service.impl;

import com.entities.Category;
import com.entities.dtos.CategoryDto;
import com.entities.models.CategoryModel;
import com.repository.CategoryRepository;
import com.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable page) {
        return this.categoryRepository.findAll(page);
    }

    @Override
    public Page<Category> findAll(Pageable page, Specification<Category> specifications) {
        return this.categoryRepository.findAll(specifications, page);
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found category id: " + id));
    }

    @Override
    public Category add(CategoryModel model) {
        Category entity = CategoryModel.toEntity(model);
        return this.categoryRepository.save(entity);
    }

    @Override
    public Category update(CategoryModel model) {
        Category original = this.findById(model.getCategoryId());
        original.setCategoryId(model.getCategoryId());
        original.setCategoryName(model.getCategoryName());
        original.setSlug(model.getSlug());
        return this.categoryRepository.save(original);
    }

    @Override
    public boolean deleteById(Long id) {
        this.categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids)
    {
        ids.forEach(this::deleteById);
        return true;
    }

    @Override
    public List<CategoryDto> getAll() {
<<<<<<< HEAD
        return null;
    }
}
=======
        return this.categoryRepository.getAll();
    }
}


>>>>>>> 257861504b623cda67d7ee2762a74775f224c269
