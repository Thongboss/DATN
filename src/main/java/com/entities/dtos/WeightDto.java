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
        private String weightName;

    public static WeightDto toDto(Weight entity) {
        if (entity == null)
            return null;
        return WeightDto.builder()
                .weightId(entity.getWeightId())
                .weightName(entity.getWeightName())
                .build();
    }
}
