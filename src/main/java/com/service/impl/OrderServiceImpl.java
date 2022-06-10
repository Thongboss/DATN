package com.service.impl;

import com.entities.OrderDetail;
import com.entities.Orders;

import com.entities.User;
import com.entities.dtos.OrderDto;

import com.entities.dtos.ResponseDto;
import com.repository.OrderRepository;
import com.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderService service;
    private final OrderRepository repository;

    public OrderServiceImpl(OrderService service, OrderRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @Transactional
    @Override
    public ResponseDto insert(OrderDto dto) {
        Orders entity = initOder(dto);
        try {
            entity = repository.save(entity);
            return new ResponseDto("Insert successfully", null,entity);
        }
        catch (Exception e) {
            return new ResponseDto("Can't insert bill", null, null);
        }
    }
    @Transactional
    @Override
    public ResponseDto update(String id, OrderDto dto) {
        if (id == null) {
            return new ResponseDto("Bill not found", null, null);
        }
        try {
            Orders entity = repository.getReferenceById(id);
            entity = initOder(dto);
            entity = repository.save(entity);
            return new ResponseDto("update successfully", null,entity);
        }
        catch (Exception e) {
            return new ResponseDto("Can't insert Bill", null, null);
        }
    }

    @Transactional
    @Override
    public ResponseDto deleteById(String id) {
        if (id == null) {
            return new ResponseDto("OrderDetail not found", null, null);
        }

        Orders removalEntity = repository.getById(id);
        repository.deleteById(id);
        return new ResponseDto("OrderDetail was deleted", null, removalEntity);
    }

    @Transactional
    @Override
    public ResponseDto getAll() {
        List<Orders> bills = repository.findAll();

        return new ResponseDto("successfully", null, bills);
    }


    private static Orders initOder(OrderDto dto) {
        return Orders.builder()
                .codeOrder(dto.getCodeOrder())
                .dateFounded(dto.getDateFounded())
                .totalMoney(dto.getTotalMoney())
                .note(dto.getNote())
                .status(dto.getStatus())
                .user(User.toEntity(dto.getUser()))
                .payments(dto.getPayments())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .build();
}}
