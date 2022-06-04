package com.entities.dtos;

import com.entities.User;
import com.entities.WarehouseDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseDetailDTO {
    private Long id;

    private Long quantity;

    private Date dateOfManufacture;

    private String expiry;

    private Long price;

    private Long productDetailId;

    private Long warehouse;

    public static WarehouseDetailDTO toDto(WarehouseDetail entity) {
        if (entity == null) throw new RuntimeException("Entity is null");
        return WarehouseDetailDTO.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .dateOfManufacture(entity.getDateOfManufacture())
                .expiry(entity.getExpiry())
                .price(entity.getPrice())
                .productDetailId(entity.getProductDetailId())
                .warehouse(entity.getWarehouse().getId())
                .build();
    }
}
