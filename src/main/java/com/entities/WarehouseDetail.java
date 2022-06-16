package com.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "warehouse_details")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class WarehouseDetail implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_manufacturee", nullable = false)
    private Date dateOfManufacture;

    @Column(name = "expiry_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    @Column(name = "price")
    private Long price;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(name = "product_details_id")
    private Long productDetailId;

    @Column(name = "product_name")
    private String productName;
    @ManyToOne
    private Warehouse warehouse;
}
