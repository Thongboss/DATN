package com.entities.dtos;

import com.entities.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long categoryId;

    private String categoryName;

    private String slug;
    private List<ProductDetailDto> productDetails;
}
