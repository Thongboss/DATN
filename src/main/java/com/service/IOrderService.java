package com.service;

import com.entities.Order;
import com.entities.dtos.OrderDto;
import com.entities.models.OrderModel;

import java.util.List;

public interface IOrderService extends IBaseService<Order, OrderModel, Long> {

    List<Order> getAllByUserId(Long userId);
}
