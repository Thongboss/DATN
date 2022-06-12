package com.repository;

import com.entities.DetailProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailProductRepository extends JpaRepository<DetailProduct,Integer> {

}

