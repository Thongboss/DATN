package com.entities.dtos;


import com.entities.ComboDetail;
import com.entities.ComboProduct;
import com.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComboDetailDto {

    private Long id;

    private ComboProductDto comboProduct;

    private ProductDto product;

    private Long quantity;

    public static ComboDetailDto toDto(ComboDetail entity) {
        if(entity == null) return null;
        return ComboDetailDto.builder()
                .id(entity.getId())
                .comboProduct(ComboProductDto.toDto(entity.getComboProduct()))
                .product(ProductDto.toDto(entity.getProduct()))
                .quantity(entity.getQuantity())
                .build();
    }
}
