package com.entities.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private Integer quantity;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfManufacture;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;

    private Long price;

    private Long productDetailId;

    private Long warehouse;
}
