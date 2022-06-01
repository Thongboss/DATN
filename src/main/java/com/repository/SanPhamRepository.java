package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Products;

public interface SanPhamRepository extends JpaRepository<Products,Integer> {

}
