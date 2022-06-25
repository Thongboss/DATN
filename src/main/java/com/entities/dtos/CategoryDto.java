package com.entities.dtos;

import com.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Long categoryId;

    private String categoryName;

    private String slug;

    public static CategoryDto toDto(Category entity) {
        if (entity == null) return null;
        return CategoryDto.builder()
                .categoryId(entity.getCategoryId())
                .categoryName(entity.getCategoryName())
                .slug(entity.getSlug())
                .build();
    }
}
