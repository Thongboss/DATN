package com.entities.dtos;

import java.util.Date;
import java.util.List;

import com.entities.Cart;
import com.entities.CartDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.javatest;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
	private Long id;
	private Date updateDate;
	private Long sunMoney;
	private List<CartDetailDto> cartDetailDto;
	private UserDto userDto;
	
	public static CartDto toDto(Cart entity) {
		if(entity == null) {
			throw new RuntimeException("CartDto is null");
		}
		return CartDto.builder()
				.id(entity.getId())
				.updateDate(entity.getUpdatedDate())
				.sunMoney(entity.getSumMoney())
				.cartDetailDto(entity.getCartDetails().stream().map(CartDetailDto::toDto).collect(java.util.stream.Collectors.toList()))
				.userDto(UserDto.toDto(entity.getCreatedUser()))
				.build();
	}
}
