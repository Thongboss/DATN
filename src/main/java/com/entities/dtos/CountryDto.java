package com.entities.dtos;

import com.entities.Country;
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
public class CountryDto {
    private Long countryId;
    private String countryName;
    private List<ProductDetailDto> productDetails;

    public static CountryDto toDto(Country entity) {
        if (entity == null)
            return null;

        return CountryDto.builder()
                .countryId(entity.getCountryId())
                .countryName(entity.getCountryName())
                .build();
    }
}
