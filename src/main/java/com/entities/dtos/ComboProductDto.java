package com.entities.dtos;

import com.entities.ComboProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComboProductDto {

    private Long id;

    private String comboName;

    private Integer quantity;

    private Double price;

    private Date createdDate;

    private Date endDate;

    private String note;

    private String images;

    private String status;

    public  static ComboProductDto toDto(ComboProduct entity){
        if (entity == null) return null;
        return ComboProductDto.builder()
                .id(entity.getId())
                .comboName(entity.getComboName())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .createdDate(entity.getCreatedDate())
                .endDate(entity.getEndDate())
                .note(entity.getNote())
                .images(entity.getImages())
                .status(entity.getStatus())
                .build();
    }
}
