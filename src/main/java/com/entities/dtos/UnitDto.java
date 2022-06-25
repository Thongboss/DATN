package com.entities.dtos;

import com.entities.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitDto {
    private Long unitId;
    private String unitName;

    public static UnitDto toDto(Unit entity) {
        if (entity == null)
            return null;
        return UnitDto.builder()
                .unitId(entity.getUnitId())
                .unitName(entity.getUnitName())
                .build();
    }
}
