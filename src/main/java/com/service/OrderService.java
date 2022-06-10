package com.service;

import com.entities.dtos.OrderDto;
import com.entities.dtos.ResponseDto;

public interface OrderService {
    ResponseDto insert(OrderDto dto);
    ResponseDto update(String id, OrderDto dto);
    ResponseDto deleteById(String id);
    ResponseDto getAll();
}
