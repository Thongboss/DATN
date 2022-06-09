package com.service;

import com.entities.dtos.BillDto;
import com.entities.dtos.BrandDto;
import com.entities.dtos.ResponseDto;

public interface BillService {
    ResponseDto insert(BillDto dto);
    ResponseDto update(String id, BillDto dto);
    ResponseDto deleteById(String id);
    ResponseDto getAll();
}
