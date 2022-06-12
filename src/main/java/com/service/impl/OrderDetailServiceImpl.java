package com.service.impl;

import com.entities.OrderDetail;
import com.entities.Orders;
import com.entities.dtos.OrderDetailDto;

import com.entities.dtos.ResponseDto;
import com.repository.OrderDetailRepository;
import com.service.OrderDetailService;
import com.service.OrderService;

import javax.transaction.Transactional;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderService service;
    private final OrderDetailRepository repository;

    public OrderDetailServiceImpl(OrderService service, OrderDetailRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    private static OrderDetail initOrderDetail(OrderDetailDto dto) {
        return OrderDetail.builder()
                .ID(dto.getId())
                .order(Orders.builder().build())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();
    }

    @Transactional
    @Override
    public ResponseDto insert(OrderDetailDto dto) {
        OrderDetail entity = initOrderDetail(dto);
        try {
            entity = repository.save(entity);
            return new ResponseDto("Insert successfully", null, entity);
        } catch (Exception e) {
            return new ResponseDto("Can't insert OrderDetail", null, null);
        }
    }

    @Transactional
    @Override
    public ResponseDto update(Long id, OrderDetailDto dto) {
        if (id == null) {
            return new ResponseDto("OrderDetail not found", null, null);
        }
        try {
            OrderDetail entity = repository.getReferenceById(id);
            entity = initOrderDetail(dto);
            entity = repository.save(entity);
            return new ResponseDto("update successfully", null, entity);
        } catch (Exception e) {
            return new ResponseDto("Can't insert Bill", null, null);
        }
    }
    @Transactional
    @Override
    public ResponseDto deleteById(Long id) {
        if (id == null) {
            return new ResponseDto("OrderDetail not found", null, null);
        }

        OrderDetail removalEntity = repository.getById(id);
        repository.deleteById(id);
        return new ResponseDto("OrderDetail was deleted", null, removalEntity);
    }

    @Override
    public ResponseDto getAll() {
        List<OrderDetail> orderDetails = repository.findAll();

        return new ResponseDto("successfully", null, orderDetails);
    }

}
