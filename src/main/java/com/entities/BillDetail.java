package com.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "billdetails")
@Builder
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @OneToMany
    @JoinColumn(name = "product_detail")
    private DetailProduct detailProduct;
    @JoinColumn(name = "quantity")
    private int quantity;
    @JoinColumn(name = "price")
    private float price;
}
