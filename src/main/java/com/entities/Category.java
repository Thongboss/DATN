package com.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Categories")
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long categoryId;

    @Column(name = "category_name", length = 255, nullable = false)
    private String categoryName;

    @Column(name = "slug", length = 255, nullable = false)
    private String slug;

    @OneToMany(mappedBy = "category")
    private List<ProductDetail> productDetails;
}
