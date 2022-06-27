package com.entities.dtos;

import com.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String productName;
    private String description;
    private Double price;
    private Integer discount;
    private Integer quantity;
    private String images;

    public static ProductDto toDto(Product entity) {
        if (entity == null) return null;
        return ProductDto.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .images(entity.getImages())
                .discount(entity.getDiscount())
                .build();
    }
    public ProductDto(Product entity) {
        if (entity != null) {
            this.setId(entity.getId());
            this.setProductName(entity.getProductName());
            this.setDescription(entity.getDescription());
            this.setPrice(entity.getPrice());
            this.setDiscount(entity.getDiscount());
            this.setQuantity(entity.getQuantity());
            this.setImages(entity.getImages());
        }


    }

}
