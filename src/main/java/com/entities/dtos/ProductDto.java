package com.entities.dtos;

import com.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String productName;
    private String description;
    private Double price;
    private Double oldPrice;
    private Integer quantity;
    private String images;
    private Boolean status;
    private BrandDto brand;
    private CategoryDto category;
    private CountryDto country;
    private UnitDto unit;
    private WeightDto weight;

    private BrandDto brandDto;
    public static ProductDto toDto(Product entity) {
        if (entity == null) return null;
        return ProductDto.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .images(entity.getImages())
                .oldPrice(entity.getOldPrice())
                .status(entity.getStatus())
                .brand(BrandDto.toDto(entity.getBrand()))
                .category(CategoryDto.toDto(entity.getCategory()))
                .country(CountryDto.toDto(entity.getCountry()))
                .unit(UnitDto.toDto(entity.getUnit()))
                .weight(WeightDto.toDto(entity.getWeight()))
                .build();
    }


}
