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
    private ProductDto productParent;
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
                .productParent(ProductDto.toDto(entity.getProductParent()))
                .oldPrice(entity.getOldPrice())
                .newPrice(entity.getNewPrice())
                .image(entity.getImage())
                .productRemain(entity.getProductRemain())
                .category(CategoryDto.toDto(entity.getCategory(), false))
                .brand(BrandDto.toDto(entity.getBrand(), false))
                .country(CountryDto.toDto(entity.getCountry(), false))
                .unit(UnitDto.toDto(entity.getUnit(), false))
                .weight(WeightDto.toDto(entity.getWeight(), false))
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .build();
    }
}
