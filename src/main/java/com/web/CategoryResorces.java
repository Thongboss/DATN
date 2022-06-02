package com.web;

import java.util.List;

import com.entities.dtos.CategoryDto;
import com.entities.dtos.ResponseDto;
import com.entities.models.CategoryModel;
import com.service.ICategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Category;

@RestController
public class CategoryResorces {

    private final ICategoryService categoryService;

    public CategoryResorces(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseDto getAll(Pageable page) {
        return ResponseDto.of(this.categoryService.findAll(page).map(CategoryDto::toDto), "Get all categories");
    }

    @GetMapping("/categories/{id}")
    public ResponseDto getById(@PathVariable("id") long id) {
//	Kiểm tra kết quả trả về có tồn tại hay không
        return ResponseDto.of(CategoryDto.toDto(this.categoryService.findById(id)), "Get category id: " + id);
    }

    @PostMapping("/categories")
    public ResponseDto createCategory(@RequestBody CategoryModel model) {
//		Kiểm tra Id có tồn tại hay không
        model.setCategoryId(null);
        return ResponseDto.of(CategoryDto.toDto(this.categoryService.add(model)), "Add category");
    }

    @PutMapping("/categories/{id}")
    public ResponseDto updateCategory(@PathVariable("id") long id, @RequestBody CategoryModel model) {
        model.setCategoryId(id);
        return ResponseDto.of(CategoryDto.toDto(this.categoryService.update(model)), "Update category id: " + id);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseDto deleteCategory(@PathVariable("id") long id) {
        return ResponseDto.of(this.categoryService.deleteById(id), "Delete category id: " + id);
    }

    @DeleteMapping("/categories/buck/{ids}")
    public ResponseDto deleteBulkCategories(@PathVariable List<Long> ids) {
        return ResponseDto.of(this.categoryService.deleteByIds(ids), "Delete buck categories: " + ids);
    }
}

