package com.entities;

import com.entities.models.CategoryModel;
import com.entities.models.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetailProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "so_luong_ton")
    private Double soLuongTon;

    @Column(name = "barcode")
    private String barCode;

    @Column(name = "han_su_dung")
    private LocalDate hanSuDung;

    @ManyToOne
    @JoinColumn(name = "san_pham_id")
    private ProductModel sanPham;

    @ManyToOne
    @JoinColumn(name = "danh_muc_id")
    private CategoryModel danhMuc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Double getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Double soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public LocalDate getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(LocalDate hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public ProductModel getSanPham() {
        return sanPham;
    }

    public void setSanPham(ProductModel sanPham) {
        this.sanPham = sanPham;
    }

    public CategoryModel getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(CategoryModel danhMuc) {
        this.danhMuc = danhMuc;
    }
}
