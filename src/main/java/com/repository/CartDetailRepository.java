package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entities.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
	@Query("SELECT sum(wd.quantity) FROM cartDetail wd WHERE wd.cartDetailId = ?1")
    Integer sumAllQuantityProduct(Long productID);
}
