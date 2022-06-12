package com.entities.dtos;

import com.entities.Weight;
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
public class WeightDto {
    private Long weightId;
    private String weightCode;
    private String weightName;
    private List<ProductDetailDto> productDetails;

    public static WeightDto toDto(Weight entity, boolean isDetail) {
        if (entity == null)
            return null;
        return WeightDto.builder()
                .weightId(entity.getWeightId())
                .weightName(entity.getWeightName())
                .productDetails(isDetail ? null :entity.getProductDetails() != null? entity.getProductDetails().stream().map(ProductDetailDto::toDto).collect(Collectors.toList()) : null)
                .build();
    }
}
