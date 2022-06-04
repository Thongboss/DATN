package com.service;

import com.entities.dtos.BrandDto;
import com.entities.dtos.OriginDto;
import com.entities.dtos.ResponseDto;

import javax.transaction.Transactional;

public interface OriginService {
    @Transactional
    ResponseDto insert(OriginDto dto);


    @Transactional
    ResponseDto update(Long id, OriginDto dto);

    ResponseDto deleteById(Long id);

    @Transactional
    ResponseDto getAll();
}
