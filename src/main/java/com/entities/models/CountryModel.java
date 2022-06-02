package com.entities.models;

import com.entities.Country;
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
public class CountryModel {
    private Long countryId;
    @NotNull
    @NotBlank
    private String countryCode;
    @NotNull
    @NotBlank
    private String countryName;

    public static Country toEntity(CountryModel model) {
        if (model == null) throw new RuntimeException("CountryModel is null");
        return Country.builder()
                .countryCode(model.getCountryCode())
                .countryName(model.getCountryName())
                .build();
    }
}
