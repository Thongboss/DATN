package com.entities.dtos;

import com.entities.Cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
	private Long id;
	
	private Long price;
	
	private Integer quantity;

    private ProductDto product;
    
    private UserDto cart;
    
    public static CartDto toDto(Cart entity) {
    	if(entity == null) {
    		return null;
    	}
    	return CartDto.builder()
    			.id(entity.getId())
//    			.price(entity.getPr())
    			.quantity(entity.getQuantity())
    			.cart(UserDto.toDto(entity.getCreatedUser()))
    			.build();
    }
}
