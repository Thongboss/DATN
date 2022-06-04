package com.entities.dtos;

import com.entities.Origin;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class OriginDto {

    private Long id;
    private String countryCode;
    private String countryName;

    public static OriginDto toDto(Origin entity) {
        if (entity != null) {
            throw new RuntimeException("Entity is null");
        }

        return OriginDto.builder()
                .id(entity.getId())
                .countryCode(entity.getCountryCode())
                .countryName(entity.getCountryName())
                .build();
    }
}
