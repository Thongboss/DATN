package com.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "combo_details")
public class ComboDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "combo_id")
    private ComboProduct comboProduct;

    @ManyToOne
    @JoinColumn(name = "combo_id")
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

}
