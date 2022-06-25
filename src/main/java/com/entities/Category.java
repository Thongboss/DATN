package com.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Setter
@Getter
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

    @Column(name = "slug", length = 255, nullable = false, unique = true)
    private String slug;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "category")
    @JsonManagedReference
    private List<Product> product;
}
