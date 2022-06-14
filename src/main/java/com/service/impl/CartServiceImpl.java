package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.entities.Cart;
import com.entities.CartDetail;
import com.entities.ProductDetail;
import com.entities.models.CartDetailModel;
import com.entities.models.CartModel;
import com.repository.CartDetailRepository;
import com.repository.CartRepository;
import com.repository.ProductDetailRepository;
import com.service.ICartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	CartRepository cartRepository;
	@Autowired
	CartDetailRepository cartDetailRepository;
	@Autowired
    ProductDetailRepository productDetailRepository;

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Cart> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return this.cartRepository.findAll(page);
	}

	@Override
	public Page<Cart> findAll(Pageable page, Specification<Cart> specifications) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart add(CartModel model) {
		Cart entity = CartModel.toEntity(model);
		
		List<Long> cartDetailIds = new ArrayList<>();
		AtomicReference<Integer> totalQuantity = new AtomicReference<>(0);
		entity.setCartDetails(model.getCartDetailModel().stream().map(dt -> 
		{
			CartDetail cartDetail = CartDetailModel.toEntity(dt);
			cartDetail.setCart(entity);
			cartDetailIds.add(dt.getProductDetail());
			totalQuantity.updateAndGet(v -> v + dt.getQuantity());
			return cartDetail;
		}).collect(Collectors.toList()));
		
		Cart cart = this.cartRepository.save(entity);
		cartDetailIds.forEach(id -> {
			ProductDetail p = productDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found product detail!"));
            p.setProductRemain(this.cartDetailRepository.sumAllQuantityProduct(id));
            this.productDetailRepository.save(p);
		});
		return cart;
	}

	@Override
	public Cart update(CartModel model) {
		// TODO Auto-generated method stub
		return this.add(model);
	}

	@Override
	public boolean deleteById(Long id) {
		this.cartRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean deleteByIds(List<Long> id) {
		// TODO Auto-generated method stub
		return false;
	}

}
