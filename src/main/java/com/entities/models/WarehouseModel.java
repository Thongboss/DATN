package com.entities.models;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder

public class WarehouseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date dateWarehouse;
    private Long sumMoney;
    private String description;
    private List<WarehouseDetailModel> warehouseDetails;
}
