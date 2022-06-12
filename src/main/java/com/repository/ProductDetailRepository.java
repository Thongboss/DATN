package com.repository;

import com.entities.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>, JpaSpecificationExecutor<ProductDetail> {

    @Query("SELECT p FROM ProductDetail p WHERE CONCAT(p.productDetailId,'') like %?1% or p.productParent.description like %?1% or p.productParent.productName like %?1%")
    Page<ProductDetail> search(String keyword, Pageable page);
}
