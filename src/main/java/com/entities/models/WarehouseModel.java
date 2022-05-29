package com.entities.models;

import com.entities.User;
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

    private String status;

    private String description;

    private Long user;

    private List<WarehouseDetailModel> warehouseDetails;
}
