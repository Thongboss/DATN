package com.entities.models;

import java.io.Serializable;

import javax.validation.constraints.Min;

import com.entities.Cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder

public class CartModel implements Serializable{
	private static final long serialVersionUID = 1L;

    private Long id;

    @NonNull
    @Min(1)
    private Integer quantity;
    
    @NonNull
    private Long price;
    
    private Long product;

    public static Cart toEntity(CartModel model) {
    	if(model == null) {
    		throw new RuntimeException("Cartdetail entity is null");
    	}
    	return Cart.builder()
    			.id(model.getId())
    			.quantity(model.getQuantity())
    			.price(model.getPrice())
    			.build();
    }
}
