package com.entities.dtos;

import com.entities.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailDto {
    private Long productDetailId;
    private String productName;
    private Long productParent;
    private Double oldPrice;
    private Double newPrice;
    private String image;
    private Integer productRemain;
    private CategoryDto category;
    private BrandDto brand;
    private CountryDto country;
    private UnitDto unit;
    private WeightDto weight;
    private Date createdDate;
    private Date updatedDate;

    public static ProductDetailDto toDto(ProductDetail entity) {
        if (entity == null) return null;
        return ProductDetailDto.builder()
                .productDetailId(entity.getProductDetailId())
                .productName(entity.getProductParent().getProductName() + " " + entity.getWeight().getWeightName())
                .productParent(entity.getProductParent().getId())
                .oldPrice(entity.getOldPrice())
                .newPrice(entity.getNewPrice())
                .image(entity.getImage())
                .productRemain(entity.getProductRemain())
                .category(CategoryDto.toDto(entity.getCategory()))
                .brand(BrandDto.toDto(entity.getBrand()))
                .country(CountryDto.toDto(entity.getCountry()))
                .unit(UnitDto.toDto(entity.getUnit()))
                .weight(WeightDto.toDto(entity.getWeight()))
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .build();
    }
}
