package com.web;

import com.service.IProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class IndexResources {
    private final IProductService productService;

    public IndexResources(IProductService productService) {
        this.productService = productService;
    }
}
