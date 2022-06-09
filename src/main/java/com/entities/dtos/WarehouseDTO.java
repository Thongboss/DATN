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

    private Date dateWarehouse;

    private Long sumMoney;

    private Date createdDate;

    private String status;

    private String description;

    private String user;

    private List<WarehouseDetailDTO> warehouseDetails;

    public static WarehouseDTO toDto(Warehouse entity) {
        if (entity == null) throw new RuntimeException("Entity is null");
        return WarehouseDTO.builder()
                .id(entity.getId())
                .dateWarehouse(entity.getDateWarehouse())
                .sumMoney(entity.getSumMoney())
                .createdDate(entity.getCreatedDate())
                .description(entity.getDescription())
                .user(entity.getUser().getFullname())
                .warehouseDetails(entity.getWarehouseDetails() == null ? null : entity.getWarehouseDetails().stream().map(dt -> WarehouseDetailDTO.toDto(dt)).collect(Collectors.toList()))
                .build();

    }
}
