package com.entities.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.entities.Cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CartModel {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Long createUser;
	
	private List<CartDetailModel> cartDetailModel;
	
	public static Cart toEntity(CartModel model) {
		if(model == null) {
			throw new RuntimeException("Cart entity is null");
		}
		
		return Cart.builder()
				.id(model.getId())
				.build();
	}
}
