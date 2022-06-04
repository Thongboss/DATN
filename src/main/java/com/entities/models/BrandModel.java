package com.entities.models;

import com.entities.Brand;
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
public class BrandModel {
    private Long brandId;

    @NotNull
    @NotBlank
    private String brandCode;
    @NotNull
    @NotBlank
    private String brandName;

    public static Brand toEntity(BrandModel model) {
        if(model== null) throw new RuntimeException("BrandModel is null");
        return Brand.builder()
                .brandCode(model.getBrandCode())
                .brandName(model.getBrandName())
                .build();
    }
}
