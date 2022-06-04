package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Category;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Category> {

}
