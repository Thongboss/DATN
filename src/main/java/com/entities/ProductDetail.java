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
@Table(name = "product_details")
@Builder
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productDetailId;

    @ManyToOne
    @JoinColumn(name = "product_parent_id")
    private Products productParent;

    @Column(name = "old_price")
    private Double oldPrice;
    @Column(name = "new_price")
    private Double newPrice;
    @Column(name = "status")
    private String status;
    @Column(name = "image")
    private String image;
    @Column(name = "product_remain")
    private Integer productRemain;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "weight_id")
    private Weight weight;
}
