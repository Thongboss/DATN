package com.web;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.entities.dtos.CartDto;
import com.entities.models.CartModel;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.entities.dtos.ResponseDto;
import com.service.ICartProductService;

@RestController
@RequestMapping("cart")
public class CartResources {
    private final ICartProductService cartService;

    public CartResources(ICartProductService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseDto list(Pageable page) {
        return ResponseDto.of(this.cartService.findAll(page).map(w -> CartDto.toDto(w)), "list cart");
    }

    @PostMapping("add")
    public ResponseDto addCart(@RequestBody @Valid CartModel model) {
        return ResponseDto.of(CartDto.toDto(this.cartService.add(model)), "Add new cart");
    }

    @PutMapping("{id}")
    public ResponseDto updateCart(@PathVariable Long id, @RequestBody @Valid CartModel model) {
        model.setId(id);
        return ResponseDto.of(CartDto.toDto(this.cartService.update(model)), "update cart");
    }

    @PatchMapping("increase/{id}")
    public ResponseDto increaseCart(@PathVariable Long id) {
        return ResponseDto.of(CartDto.toDto(this.cartService.increase(id)), "increase cart");
    }

    @PatchMapping("decrease/{id}")
    public ResponseDto decreaseCart(@PathVariable Long id) {
        return ResponseDto.of(CartDto.toDto(this.cartService.decrease(id)), "decrease cart");
    }

    @DeleteMapping("public/{id}")
    public ResponseDto deleteCart(@PathVariable Long id) {
        return ResponseDto.of(this.cartService.deleteById(id) ? true : null, "Delete id");
    }

    @GetMapping("my-cart")
    public ResponseDto myCart(){
        return ResponseDto.of(this.cartService.myCart(), "my cart");
    }
//    @GetMapping("{id}")
//    public ResponseDto findWarehouseById(@PathVariable Long id){
//        return ResponseDto.of(WarehouseDTO.toDto(this.warehouseService.findById(id)), "Find by id warehouse");
//    }
}
