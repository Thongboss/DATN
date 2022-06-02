package com.entities.dtos;

import com.entities.Country;
import com.entities.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDto {
    private Long countryId;
    private String countryCode;
    private String countryName;
    private List<ProductDetailDto> productDetails;

    public static CountryDto toDto(Country entity){
        return  null;
    }
}
