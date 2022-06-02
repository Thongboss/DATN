package com.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {

    private Long categoryId;

    private String categoryName;

    private String slug;
}
