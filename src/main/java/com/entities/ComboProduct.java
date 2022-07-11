package com.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "combo_product")
public class ComboProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "combo_name", length = 255, nullable = false)
    private String comboName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "note", length = 500)
    private String note;

    @Column(name = "image")
    private String images;

    @Column(name = "status", length = 200)
    private String status;
}
