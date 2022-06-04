package com.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "warehouse_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class WarehouseDetail implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_manufacturee", nullable = false)
    private Date dateOfManufacture;

    @Column(name = "expiry", nullable = false)
    private String expiry;

    @Column(name = "price")
    private Long price;

//    @ManyToOne
    @Column(name = "product_details_id")
    private Long productDetailId;


    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
}