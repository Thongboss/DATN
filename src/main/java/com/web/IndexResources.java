package com.web;

import com.entities.Order;
import com.entities.Product;
import com.entities.dtos.ProductDto;
import com.entities.dtos.ResponseDto;
import com.entities.models.UserModel;
import com.service.ICategoryService;
import com.service.IOrderService;
import com.service.IProductService;

import java.util.List;

import com.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class IndexResources {
    private final IProductService productService;
    private final ICategoryService categoryService;

    private final IOrderService orderService;

    private final IUserService userService;


    @GetMapping("/index")
    private ResponseDto getAll() {
        return ResponseDto.of(categoryService.getAll(), "get all category");
    }
    
    @GetMapping("/index/search")
    public List<Product> searchProduct(@RequestParam(name="search", required = false) String name){
        List<Product> list = null;
        if(StringUtils.hasText(name)){
            list = productService.findByNameContaining(name);
        }else{
            list = productService.findAll();
        }
        return list;
    }

    @GetMapping("/index/products/{id}")
    public ResponseDto getProduct(@PathVariable("id") long id){
      return  ResponseDto.of(ProductDto.toDto(this.productService.findById(id)), "Get product id " + id);
    }

// Hiển thị hóa đơn theo id user:
    @GetMapping("/index/orders")
    public List<Order> OrderByUserId(@RequestParam(name="user_id" ,required=false) long user_id){
        List<Order> list=orderService.getAllOrderByUserId(user_id);
        return list;
    }

    //    Update mật khẩu user
    @Transactional
    @PutMapping("/index/user{id}")
    public ResponseDto update(@PathVariable long id, @RequestBody UserModel userModel) {
        userModel.setId(id);
        return ResponseDto.of(this.userService.update(userModel), "Update user id: " + id);
    }
}
