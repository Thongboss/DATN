package com.service;

import com.entities.Cart;
import com.entities.models.CartModel;

import java.util.List;

public interface ICartProductService extends IBaseService<Cart, CartModel, Long>{

    Cart increase(Long id);

    Cart decrease(Long id);

    List<Cart> myCart();
}
