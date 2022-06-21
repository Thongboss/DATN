package com.service.impl;

import com.entities.Weight;
import com.entities.models.WeightModel;
import com.repository.WeightRepository;
import com.service.IWeightService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightServiceImpl implements IWeightService {
    private final WeightRepository weightRepository;

    public WeightServiceImpl(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @Override
    public List<Weight> findAll() {
        return this.weightRepository.findAll();
    }

    @Override
    public Page<Weight> findAll(Pageable page) {
        return this.weightRepository.findAll(page);
    }

    @Override
    public Page<Weight> findAll(Pageable page, Specification<Weight> specifications) {
        return this.weightRepository.findAll(specifications, page);
    }

    @Override
    public Weight findById(Long id) {
        return this.weightRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found weight id: " + id));
    }

    @Override
    public Weight add(WeightModel model) {
        Weight entity = WeightModel.toEntity(model);
        return this.weightRepository.save(entity);
    }

    @Override
    public Weight update(WeightModel model) {
        Weight original = this.findById(model.getWeightId());
        original.setWeightId(model.getWeightId());
        original.setWeightName(model.getWeightName());
        return this.weightRepository.save(original);
    }

    @Override
    public boolean deleteById(Long id) {
        this.weightRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
        return true;
    }
}
