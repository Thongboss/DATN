package com.service.impl;

import java.util.List;

import com.Utils.SecurityUtils;
import com.repository.CartRepository;
import com.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.entities.Cart;
import com.entities.models.CartModel;
import com.service.ICartProductService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartProductService {

    private final CartRepository cartRepository;
    private final IProductService productService;

    public CartServiceImpl(CartRepository cartRepository, IProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }


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
        return this.cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    @Override
    public Cart add(CartModel model) {
        Cart cart = this.cartRepository.findByProductIdAndCreatedUserId(model.getProduct(), SecurityUtils.getCurrentUser().getUser().getId()).orElse(CartModel.toEntity(model));
        if(cart.getId() != null)
            cart.setQuantity(cart.getQuantity() + model.getQuantity());
        cart.setProduct(productService.findById(model.getProduct()));
        cart.setCreatedUser(SecurityUtils.getCurrentUser().getUser());
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart update(CartModel model) {
        Cart cart = this.findById(model.getId());
        cart.setQuantity(model.getQuantity());
        return this.cartRepository.save(cart);
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean deleteByIds(List<Long> id) {
        return false;
    }

    @Override
    public Cart increase(Long id) {
        Cart cart = this.findById(id);
        cart.setQuantity(cart.getQuantity() + 1);
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart decrease(Long id) {
        Cart cart = this.findById(id);
        cart.setQuantity(cart.getQuantity() - 1);
        return this.cartRepository.save(cart);
    }

    @Override
    public List<Cart> myCart() {
        return null;
    }
}
