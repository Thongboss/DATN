package com.entities.models;

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
public class ComboProductModel {

    private Long id;
    @NotNull
    @NotBlank
    private String comboName;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double price;

    @NotNull
    private Date createdDate;

    @NotNull
    private Date endDate;

    @NotNull
    private String note;

    @NotNull
    private String images;

    @NotNull
    private String status;

    public static ComboProduct toEntity(ComboProductModel model){
        if (model == null) throw new RuntimeException("ComboProductModel is null");
        return ComboProduct.builder()
                .id(model.getId())
                .comboName(model.getComboName())
                .quantity(model.getQuantity())
                .price(model.getPrice())
                .createdDate(model.getCreatedDate())
                .endDate(model.getEndDate())
                .note(model.getNote())
                .images(model.getImages())
                .status(model.getStatus())
                .build();
    }
}
