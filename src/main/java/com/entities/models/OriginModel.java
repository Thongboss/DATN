package com.entities.models;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class OriginModel implements Serializable {
    private Long id;
    private String countryCode;
    private String countryName;
}
