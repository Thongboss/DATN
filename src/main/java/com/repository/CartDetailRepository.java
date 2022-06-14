package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entities.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
	@Query("SELECT sum(wd.quantity) FROM CartDetail wd WHERE wd.productDetail.productDetailId = ?1")
    Integer sumAllQuantityProduct(Long productID);
}
