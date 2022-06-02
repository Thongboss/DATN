package com.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SanPham")
public class ProductModel {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "Tensp",length =255, nullable = false)
    private String Tensp;

    @Column(name = "Ghichu",length =255, nullable = true)
    private String Ghichu;

    @Column(name = "Trangthai",length =255, nullable = false)
    private String Trangthai;

}