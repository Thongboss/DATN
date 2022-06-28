package com.service.impl;

import com.config.jwt.JwtProvider;

import com.entities.Order;
import com.entities.models.OrderModel;
import com.repository.OrderDetailRepository;
import com.repository.OrderRepository;
import com.service.IOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final JwtProvider jwtProvider;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, JwtProvider jwtProvider) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable page) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable page, Specification<Order> specifications) {
        return null;
    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public Order add(OrderModel model) {
        return null;
    }

    @Override
    public Order update(OrderModel model) {
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


    @Override
    public List<Order> getAllOrderByUserId(Long userId) {
        return null;
    }
}
