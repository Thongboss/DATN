package com.entities.models;


import com.entities.ComboDetail;
import com.entities.ComboProduct;
import com.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComboDetailModel {

    private Long id;

    private ComboProduct comboProduct;

    private Product product;

    @NotNull
    private Long quantity;

    public static ComboDetail toEnity(ComboDetailModel model) {
        if(model == null) throw new RuntimeException("ComboProductModel is null");
        return ComboDetail.builder()
                .id(model.getId())
                .comboProduct(model.getComboProduct())
                .quantity(model.getQuantity())
                .build();
    }
}
