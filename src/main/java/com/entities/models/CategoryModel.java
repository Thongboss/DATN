package com.entities.models;

import com.entities.Category;
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
public class CategoryModel {

    private Long categoryId;

    @NotNull
    @NotBlank
    private String categoryName;

    private String slug;

    public static Category toEntity(CategoryModel model) {
        if(model== null) throw new RuntimeException("CategoryModel is null");
        return Category.builder()
                .categoryName(model.getCategoryName())
                .slug(model.getSlug())
                .build();
    }
}
