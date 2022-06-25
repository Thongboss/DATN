package com.entities.dtos;

import com.entities.User;
import com.entities.Warehouse;
import com.entities.models.WarehouseDetailModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseDTO {
    private Long id;


    private Double sumMoney;

    private Date createdDate;
    private Date updatedDate;

    private String description;

    private String user;

    private Integer totalQuantity;

    public static WarehouseDTO toDto(Warehouse entity) {
        if (entity == null) return null;
        return WarehouseDTO.builder()
                .id(entity.getId())
                .sumMoney(entity.getSumMoney())
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .totalQuantity(entity.getTotalQuantity())
                .description(entity.getDescription())
                .user(entity.getUser().getFullname())
                .build();

    }
}
