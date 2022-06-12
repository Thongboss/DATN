package com.entities.models;

import com.entities.Weight;
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
public class WeightModel {
    private Long weightId;
    @NotNull
    @NotBlank
    private String weightName;

    public static Weight toEntity(WeightModel model) {
        if (model == null) throw new RuntimeException("WeightModel is null");
        return Weight.builder()
                .weightName(model.getWeightName())
                .build();
    }
}
