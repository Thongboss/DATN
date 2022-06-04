package com.service;

import com.entities.dtos.BrandDto;
import com.entities.dtos.ResponseDto;

public interface BrandService {

    ResponseDto insert(BrandDto dto);
    ResponseDto update(Long id, BrandDto dto);
    ResponseDto deleteById(Long id);
    ResponseDto getAll();
}
