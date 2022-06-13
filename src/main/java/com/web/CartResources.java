package com.web;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.dtos.CartDto;
import com.entities.dtos.ResponseDto;
import com.entities.models.CartModel;
import com.service.ICartService;

@RestController
@RequestMapping("cart")
public class CartResources {
	private final ICartService cartService;
	
	public CartResources(ICartService cartService) {
		this.cartService = cartService;
	}
	
	@GetMapping
    public ResponseDto list(Pageable page){
        return ResponseDto.of(this.cartService.findAll(page).map(w -> CartDto.toDto(w)),"list warehouse");
    }
    @PostMapping
    public ResponseDto addCart(@RequestBody @Valid CartModel model){
        model.setId(null);
        return ResponseDto.of(CartDto.toDto(this.cartService.add(model)), "Add new Warehouse");
    }
    @PutMapping("{id}")
    public ResponseDto updateCart(@PathVariable Long id, @RequestBody @Valid CartModel model){
        model.setId(id);
        return ResponseDto.of(CartDto.toDto(this.cartService.update(model)), "update Warehouse");
    }
    @DeleteMapping("{id}")
    public ResponseDto deleteCart(@PathVariable Long id){
        return ResponseDto.of(this.cartService.deleteById(id)?true:null, "Delete id");
    }
//    @GetMapping("{id}")
//    public ResponseDto findWarehouseById(@PathVariable Long id){
//        return ResponseDto.of(WarehouseDTO.toDto(this.warehouseService.findById(id)), "Find by id warehouse");
//    }
}
