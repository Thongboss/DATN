package com.entities.models;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class BrandModel implements Serializable {
    private Long id;
    private String code;
    private String name;
    private String note;
    private Boolean status = true;
}
