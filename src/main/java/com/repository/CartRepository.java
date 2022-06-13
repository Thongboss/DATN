package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
