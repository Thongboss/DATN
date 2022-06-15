package com.entities.dtos;

import com.entities.CartDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDetailDto {
	private Long id;
	
	private Long price;
	
	private Integer quantity;

    private ProductDetailDto productDetail;
    
    private CartDto cart;
    
    public static CartDetailDto toDto(CartDetail entity) {
    	if(entity == null) {
    		throw new RuntimeException("CartDetail DTO is null");
    	}
    	return CartDetailDto.builder()
    			.id(entity.getId())
    			.price(entity.getPrice())
    			.quantity(entity.getQuantity())
    			.cart(CartDto.toDto(entity.getCart()))
    			.build();
    }
}
