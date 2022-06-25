package com.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterModel {
    private Long id;
    private String productName;
    private String description;
    private String status;
    private Double price;
    private Long quantity;
    private String image;
    private Long category;
    private Long brand;
    private Long country;
    private Long unit;
    private Long weight;
}
