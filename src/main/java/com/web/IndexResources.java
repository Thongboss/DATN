package com.web;

import com.entities.dtos.ResponseDto;
import com.service.ICategoryService;
import com.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class IndexResources {
    private final IProductService productService;
    private final ICategoryService categoryService;

    public IndexResources(IProductService productService, ICategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    private ResponseDto getAll() {
        return ResponseDto.of(categoryService.getAll(), "get all category");
    }

}
