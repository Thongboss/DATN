package com.entities.models;

import com.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailModel {
    private Long productDetailId;
    private Long productParent;
    private Double oldPrice;
    private Double newPrice;
    private String status;
    private String image;
    private Integer productRemain;
    private Long category;
    private Long brand;
    private Long country;
    private Long unit;
    private Long weight;
}
