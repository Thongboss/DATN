package com.entities.models;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class WarehouseDetailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long quantity;

    private Date dateOfManufacture;

    private String expiry;

    private Long price;

    private Long productDetailId;

    private Long warehouse;
}
