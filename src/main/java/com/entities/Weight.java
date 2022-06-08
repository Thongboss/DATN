package com.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weights")
@Builder
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weightId;
    @Column(name = "weight_code",  unique = true)
    private String weightCode;
    @Column(name = "weight_name")
    private String weightName;
    @OneToMany(mappedBy = "weight")
    private List<ProductDetail> productDetails;
}
