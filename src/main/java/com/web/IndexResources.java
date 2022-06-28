package com.web;

import com.entities.Order;
import com.entities.Product;
import com.entities.dtos.OrderDto;
import com.entities.dtos.ProductDto;
import com.entities.dtos.ResponseDto;
import com.service.ICategoryService;
import com.service.IOrderService;
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

    private final IOrderService orderService;

    public IndexResources(IProductService productService, ICategoryService categoryService, IOrderService orderService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.orderService = orderService;
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

    @GetMapping("products/{id}")
    public ResponseDto getProduct(@PathVariable("id") long id){
      return  ResponseDto.of(ProductDto.toDto(this.productService.findById(id)), "Get product id " + id);
    }

// Hiển thị hóa đơn theo id user:
    @GetMapping("orders/{user_id}")
    public List<Order> OrderByUserId(@PathVariable("user_id") long user_id){
        List<Order> list=orderService.getAllByUserId(user_id);
        return list;
    }

}
