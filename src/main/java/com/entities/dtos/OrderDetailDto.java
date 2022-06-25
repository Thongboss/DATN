package com.entities.dtos;

import com.entities.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDto {
    private Long id;
    private ProductDto detailProduct;
    private Integer quantity;
    private Double price;

    public static OrderDetailDto toDto(OrderDetail entity) {
        if (entity == null) {
            return null;
        }
        return OrderDetailDto.builder()
                .id(entity.getId())
                .detailProduct(ProductDto.toDto(entity.getDetailProduct()))
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .build();
    }
}
