package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

}
