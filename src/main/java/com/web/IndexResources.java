package com.web;

import com.entities.Product;
import com.entities.dtos.ResponseDto;
import com.service.ICategoryService;
import com.service.IProductService;

import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("search")
    public List<Product> searchProduct(@RequestParam(name="search", required = false) String name){
        List<Product> list = null;
        if(StringUtils.hasText(name)){
            list = productService.findByNameContaining(name);
        }else{
            list = productService.findAll();
        }
        return list;
    }

}
