package com.entities.models;

import com.entities.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitModel {
    private Long unitId;
    @NotNull
    @NotBlank
    private String unitCode;
    @NotNull
    @NotBlank
    private String unitName;

    public static Unit toEntity(UnitModel model){
        if(model == null) throw new RuntimeException("UnitModel is null");
        return Unit.builder()
                .unitCode(model.getUnitCode())
                .unitName(model.getUnitName())
                .build();
    }
}
