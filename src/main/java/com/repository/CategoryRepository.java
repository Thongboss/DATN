package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Categories;

public interface CategoryRepository extends JpaRepository<Categories,Long> {

}
