package com.entities.dtos;

import com.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandDto {
    private Long brandId;
    private String brandCode;
    private String brandName;
    private List<ProductDetailDto> productDetails;

    public static BrandDto toDto(Brand entity, boolean isDetail) {
        if (entity == null) return null;
        return BrandDto.builder()
                .brandId(entity.getBrandId())
                .brandCode(entity.getBrandCode())
                .brandName(entity.getBrandName())
                .productDetails(!isDetail ? null : entity.getProductDetails() != null? entity.getProductDetails().stream().map(ProductDetailDto::toDto).collect(Collectors.toList()) : null)
                .build();
    }
}
