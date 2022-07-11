package com.service.impl;


import com.entities.ComboDetail;
import com.entities.ComboProduct;
import com.entities.models.ComboDetailModel;
import com.repository.ComboDetailRepository;

import com.service.IComboDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ComboDetailImpl implements IComboDetailService {

    private final ComboDetailRepository comboDetailRepository;


    @Override
    public List<ComboDetail> findAll() {
        return comboDetailRepository.findAll();
    }

    @Override
    public Page<ComboDetail> findAll(Pageable page) {
        return null;
    }

    @Override
    public Page<ComboDetail> findAll(Pageable page, Specification<ComboDetail> specifications) {
        return null;
    }

    @Override
    public ComboDetail findById(Long id) {
        return comboDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found Combo Detail id: " + id));
    }

    @Override
    public ComboDetail add(ComboDetailModel model) {
        ComboDetail entity = ComboDetailModel.toEnity(model);
        return comboDetailRepository.save(entity);
    }

    @Override
    public ComboDetail update(ComboDetailModel model) {
        return add(model);
    }

    @Override
    public boolean deleteById(Long id) {
        this.comboDetailRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
        return true;
    }

    @Override
    public List<ComboDetail> getAll() {
        return comboDetailRepository.findAll();
    }
}
