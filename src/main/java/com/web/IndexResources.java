package com.web;

import com.entities.ComboProduct;
import com.entities.Order;
import com.entities.Product;
import com.entities.dtos.ComboDetailDto;
import com.entities.dtos.ComboProductDto;
import com.entities.dtos.ProductDto;
import com.entities.dtos.ResponseDto;
import com.entities.models.ComboDetailModel;
import com.entities.models.ComboProductModel;
import com.entities.models.ProductModel;
import com.entities.models.UserModel;
import com.service.*;

import java.util.List;

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

    private final IComboProductService comboProductService ;

    private final IComboDetailService comboDetailService;


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

//    Comboproduct :
    @GetMapping("/index/combo-products")
    public ResponseDto getComboProducts(){
        return ResponseDto.of(comboProductService.getAll(), "get all comboProduct");
    }
    @GetMapping("/index/combo-products/{id}")
    public ResponseDto getComboProduct(@PathVariable("id") long id) {
//		Kiểm tra kết quả trả về có tồn tại hay không
        return ResponseDto.of(ComboProductDto.toDto(this.comboProductService.findById(id)), "Get ComboProduct id: " + id);
    }
    @PostMapping("/index/combo-products")
    public ResponseDto createComboProduct(@RequestBody ComboProductModel model) {
        model.setId(null);
        return ResponseDto.of(this.comboProductService.add(model), "Add ComboProduct");
    }
//    Update ComboProduct
    @PutMapping("/index/combo-products/{id}")
    public ResponseDto updateComboProducts(@PathVariable("id") Long id, @RequestBody ComboProductModel model) {
        model.setId(id);
        return ResponseDto.of(ComboProductDto.toDto(this.comboProductService.update(model)), "Update ComboProduct id: " + id);
    }

    @DeleteMapping("/index/combo-products/{id}}")
    public ResponseDto deleteComboProduct(@PathVariable("id") long id) {
        return ResponseDto.of(this.comboProductService.deleteById(id), "Delete CommboProduct id: " + id);
    }


//    CRUD ComboDetail :

    @GetMapping("/index/combo-details")
    public ResponseDto getComboDetails(){
        return ResponseDto.of(comboDetailService.getAll(), "get all comboDetails");
    }

    @GetMapping("/index/combo-details/{id}")
    public ResponseDto getComboDetail(@PathVariable("id") long id) {
//		Kiểm tra kết quả trả về có tồn tại hay không
        return ResponseDto.of(ComboDetailDto.toDto(this.comboDetailService.findById(id)), "Get ComboDetail id: " + id);
    }
    @PostMapping("/index/combo-details")
    public ResponseDto createComboDetail(@RequestBody ComboDetailModel model) {
        model.setId(null);
        return ResponseDto.of(this.comboDetailService.add(model), "Add ComboDetail");
    }
    //    Update Combo Detail
    @PutMapping("/index/combo-detail/{id}")
    public ResponseDto updateComboDetail(@PathVariable("id") Long id, @RequestBody ComboDetailModel model) {
        model.setId(id);
        return ResponseDto.of(ComboDetailDto.toDto(this.comboDetailService.update(model)), "Update Combo Detail id: " + id);
    }

    @DeleteMapping("/index/combo-detail/{id}}")
    public ResponseDto deleteComboDetail(@PathVariable("id") long id) {
        return ResponseDto.of(this.comboDetailService.deleteById(id), "Delete Commbo Detail id: " + id);
    }

}
