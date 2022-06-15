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

    private Integer quantity;

    private Date dateOfManufacture;

    private Date expireDate;
    private Double subTotal;

    private Long price;

    private String productName;

    private Long warehouse;

    public static WarehouseDetailDTO toDto(WarehouseDetail entity) {
        if (entity == null) throw new RuntimeException("Entity is null");
        return WarehouseDetailDTO.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .dateOfManufacture(entity.getDateOfManufacture())
                .expireDate(entity.getExpireDate())
                .subTotal(entity.getSubTotal())
                .price(entity.getPrice())
                .productName(entity.getProductName())
                .warehouse(entity.getWarehouse().getId())
                .build();
    }
}
