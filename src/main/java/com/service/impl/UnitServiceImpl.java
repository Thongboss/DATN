package com.service.impl;

import com.entities.Unit;
import com.entities.models.UnitModel;
import com.repository.UnitRepository;
import com.service.IUnitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements IUnitService {
    private final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public List<Unit> findAll() {
        return this.unitRepository.findAll();
    }

    @Override
    public Page<Unit> findAll(Pageable page) {
        return this.unitRepository.findAll(page);
    }

    @Override
    public Page<Unit> findAll(Pageable page, Specification<Unit> specifications) {
        return this.unitRepository.findAll(specifications, page);
    }

    @Override
    public Unit findById(Long id) {
        return this.unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found unit id: " + id));
    }

    @Override
    public Unit add(UnitModel model) {
        Unit entity = UnitModel.toEntity(model);
        return this.unitRepository.save(entity);
    }

    @Override
    public Unit update(UnitModel model) {
        Unit original = this.findById(model.getUnitId());
        original.setUnitId(model.getUnitId());
        original.setUnitName(model.getUnitName());
        return this.unitRepository.save(original);
    }

    @Override
    public boolean deleteById(Long id) {
        this.unitRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
        return true;
    }
}
