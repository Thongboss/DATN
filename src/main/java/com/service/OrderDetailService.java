package com.service;


import com.entities.dtos.OrderDetailDto;
import com.entities.dtos.ResponseDto;

public interface OrderDetailService {
    ResponseDto insert(OrderDetailDto dto);
    ResponseDto update(Long id, OrderDetailDto dto);
    ResponseDto deleteById(Long id);
    ResponseDto getAll();
}
