package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Cart;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long>{
    Optional<Cart> findByProductIdAndCreatedUserId(Long productId, Long userId);
}
