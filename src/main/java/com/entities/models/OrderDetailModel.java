package com.entities.models;

import com.entities.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailModel {
    private Long id;
    @NotNull
    private Long detailProduct;

    @NotNull
    @Min(1)
    private Integer quantity;

    public static OrderDetail toEntity(OrderDetailModel model){
        if(model == null){
            throw new RuntimeException("Entity is null");
        }
        return OrderDetail.builder()
                .id(model.getId())
                .quantity(model.getQuantity())
                .build();
    }
}
