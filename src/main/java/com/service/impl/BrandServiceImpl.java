package com.service.impl;

import com.entities.Brand;
import com.entities.dtos.BrandDto;
import com.entities.dtos.ResponseDto;
import com.repository.BrandRepository;
import com.service.BrandService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandService service;
    private final BrandRepository repository;

    public BrandServiceImpl(BrandService service, BrandRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @Transactional
    @Override
    public ResponseDto insert(BrandDto dto) {
        Brand entity = initBrand(dto);
        try {
            entity = repository.save(entity);
            return new ResponseDto("Insert successfully", null,entity);
        }
        catch (Exception e) {
            return new ResponseDto("Can't insert brand", null, null);
        }
    }

    private static Brand initBrand(BrandDto dto) {
        return Brand.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .note(dto.getNote())
                .status(dto.getStatus())
                .build();
    }

    @Transactional
    @Override
    public ResponseDto update(Long id, BrandDto dto) {
        if (id == null) {
            return new ResponseDto("brand not found", null, null);
        }
        Brand entity = repository.getById(id);
        entity = initBrand(dto);
        try {
            entity = repository.save(entity);
            return new ResponseDto("update successfully", null,entity);
        }
        catch (Exception e) {
            return new ResponseDto("Can't insert brand", null, null);
        }
    }

    @Override
    public ResponseDto deleteById(Long id) {
        if (id == null) {
            return new ResponseDto("brand not found", null, null);
        }

        Brand removalEntity = repository.getById(id);
        return new ResponseDto("Brand was deleted", null, removalEntity);
    }

    @Transactional
    @Override
    public ResponseDto getAll() {
        List<Brand> brands = repository.findAll();

        return new ResponseDto("successfully", null, brands);
    }
}
