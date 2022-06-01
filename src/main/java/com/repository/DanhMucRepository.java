package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Categories;

public interface DanhMucRepository extends JpaRepository<Categories,Integer> {

}
