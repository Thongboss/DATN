package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {

}
