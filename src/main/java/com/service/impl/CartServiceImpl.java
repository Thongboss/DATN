package com.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.entities.Cart;
import com.entities.models.CartModel;
import com.service.ICartProductService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartProductService {

	@Override
	public List<Cart> findAll() {
		return null;
	}

	@Override
	public Page<Cart> findAll(Pageable page) {
		return null;
	}

	@Override
	public Page<Cart> findAll(Pageable page, Specification<Cart> specifications) {
		return null;
	}

	@Override
	public Cart findById(Long id) {
		return null;
	}

	@Override
	public Cart add(CartModel model) {
		return null;
	}

	@Override
	public Cart update(CartModel model) {
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		return false;
	}

	@Override
	public boolean deleteByIds(List<Long> id) {
		return false;
	}
}
