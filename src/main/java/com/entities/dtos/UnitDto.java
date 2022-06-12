package com.entities.dtos;

import com.entities.ProductDetail;
import com.entities.Unit;
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
public class UnitDto {
    private Long unitId;
    private String unitName;
    private List<ProductDetailDto> productDetails;

    public static UnitDto toDto(Unit entity, boolean isDetail) {
        if (entity == null)
            return null;
        return UnitDto.builder()
                .unitId(entity.getUnitId())
                .unitName(entity.getUnitName())
                .productDetails(isDetail ? null :entity.getProductDetails() != null? entity.getProductDetails().stream().map(ProductDetailDto::toDto).collect(Collectors.toList()) : null)
                .build();
    }
}
