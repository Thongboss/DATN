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
@Table(name = "units")
@Builder
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitId;
    @Column(name = "unit_code")
    private String unitCode;
    @Column(name = "unit_name")
    private String unitName;
    @OneToMany(mappedBy = "unit")
    private List<ProductDetail> productDetails;
}
