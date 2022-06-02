package com.entities.dtos;

import com.entities.ProductDetail;
import com.entities.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitDto {
    private Long unitId;
    private String unitCode;
    private String unitName;
    private List<ProductDetailDto> productDetails;

    public static UnitDto toDto(Unit entity){
        return null;
    }
}
