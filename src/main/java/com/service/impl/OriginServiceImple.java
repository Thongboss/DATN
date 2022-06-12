package com.service.impl;

import com.entities.Origin;
import com.entities.dtos.BrandDto;
import com.entities.dtos.OriginDto;
import com.entities.dtos.ResponseDto;
import com.repository.OriginRepository;
import com.service.OriginService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OriginServiceImple implements OriginService {
    private final OriginService service;
    private final OriginRepository repository;

    public OriginServiceImple(OriginService service, OriginRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @Transactional
    @Override
    public ResponseDto insert(OriginDto dto) {
        Origin entity = initOrigin(dto);
        try {
            entity = repository.save(entity);
            return new ResponseDto("Insert successfully", null,entity);
        }
        catch (Exception e) {
            return new ResponseDto("Can't insert brand", null, null);
        }
    }


    private static Origin initOrigin(OriginDto dto) {
        return Origin.builder()
                .id(dto.getId())
                .countryCode(dto.getCountryCode())
                .countryName(dto.getCountryName())
                .build();
    }

    @Transactional
    @Override
    public ResponseDto update(Long id, OriginDto dto) {
        if (id == null) {
            return new ResponseDto("brand not found", null, null);
        }
        Origin entity = repository.getById(id);
        entity = initOrigin(dto);
        try {
            entity = repository.save(entity);
            return new ResponseDto("update successfully", null,entity);
        }
        catch (Exception e) {
            return new ResponseDto("Can't insert Origin", null, null);
        }
    }

    @Override
    public ResponseDto deleteById(Long id) {
        if (id == null) {
            return new ResponseDto("Origin not found", null, null);
        }

        Origin removalEntity = repository.getById(id);
        return new ResponseDto("Brand was deleted", null, removalEntity);
    }

    @Transactional
    @Override
    public ResponseDto getAll() {
        List<Origin> brands = repository.findAll();

        return new ResponseDto("successfully", null, brands);
    }
}
