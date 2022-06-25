package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Cart;

public interface CartDetailRepository extends JpaRepository<Cart, Long>{
}
