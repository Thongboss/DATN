package com.service.impl;

import com.entities.Bill;

import com.entities.User;
import com.entities.dtos.BillDto;

import com.entities.dtos.ResponseDto;
import com.repository.BillRepository;
import com.service.BillService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private final BillService service;
    private final BillRepository repository;

    public BillServiceImpl(BillService service, BillRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @Transactional
    @Override
    public ResponseDto insert(BillDto dto) {
        Bill entity = initBill(dto);
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
    public ResponseDto update(String id, BillDto dto) {
        if (id == null) {
            return new ResponseDto("Bill not found", null, null);
        }
        try {
            Bill entity = repository.getReferenceById(id);
            entity = initBill(dto);
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
            return new ResponseDto("Bill not found", null, null);
        }

        Bill removalEntity = repository.getById(id);
        repository.deleteById(id);
        return new ResponseDto("Bill was deleted", null, removalEntity);
    }

    @Transactional
    @Override
    public ResponseDto getAll() {
        List<Bill> bills = repository.findAll();

        return new ResponseDto("successfully", null, bills);
    }


    private static Bill initBill(BillDto dto) {
        return Bill.builder()
                .codeBill(dto.getCodeBill())
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
