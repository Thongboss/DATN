package com.entities.dtos;

import com.entities.Category;
import com.entities.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Long categoryId;

    private String categoryName;

    private String slug;
    private List<ProductDetailDto> productDetails;

    public static CategoryDto toDto(Category entity ){
        if(entity == null) return null;
        return CategoryDto.builder()
                .categoryId(entity.getCategoryId())
                .categoryName(entity.getCategoryName())
                .slug(entity.getSlug())
                .productDetails(entity.getProductDetails() != null? entity.getProductDetails().stream().map(ProductDetailDto::toDto).collect(Collectors.toList()) : null)
                .build();
    }
}
