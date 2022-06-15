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
    private String brandName;

    public static BrandDto toDto(Brand entity) {
        if (entity == null) return null;
        return BrandDto.builder()
                .brandId(entity.getBrandId())
                .brandName(entity.getBrandName())
                .build();
    }
}
