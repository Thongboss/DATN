package com.repository;

import com.entities.dtos.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Category;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Category> {
    @Query("select new com.entities.dtos.CategoryDto(entity) from Category entity" )
    List<CategoryDto> getAll();
}
