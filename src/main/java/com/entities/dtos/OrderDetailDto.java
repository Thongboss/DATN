package com.entities.dtos;

import com.entities.Brand;
import com.entities.OrderDetail;
import com.entities.Orders;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class OrderDetailDto {
    private Long id;
    private Long id_order;
    private Long id_detailProduct;
    private Integer quantity;
    private Double price;

    public static OrderDetailDto toDto(OrderDetail entity) {
        if (entity == null) {
            throw new RuntimeException("Entity is null");
        }
        return OrderDetailDto.builder()
                .id(entity.getID())
                .id_order(entity.getOrder().getId())
                .id_detailProduct(entity.getDetailProduct().getId())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .build();
    }
}
