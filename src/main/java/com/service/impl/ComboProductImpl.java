package com.service.impl;

import com.entities.ComboProduct;
import com.entities.models.ComboProductModel;
import com.repository.ComboProductRepository;
import com.service.IComboProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ComboProductImpl implements IComboProductService {

    private final ComboProductRepository comboProductRepository;
    @Override
    public List<ComboProduct> findAll() {
        return comboProductRepository.findAll();
    }

    @Override
    public Page<ComboProduct> findAll(Pageable page) {
        return null;
    }

    @Override
    public Page<ComboProduct> findAll(Pageable page, Specification<ComboProduct> specifications) {
        return null;
    }

    @Override
    public ComboProduct findById(Long id) {
        return this.comboProductRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found ComboProduct id : " + id));
    }

    @Override
    public ComboProduct add(ComboProductModel model) {
        ComboProduct entity = ComboProductModel.toEntity(model);
        return comboProductRepository.save(entity);
    }

    @Override
    public ComboProduct update(ComboProductModel model) {
        return add(model);
    }

    @Override
    public boolean deleteById(Long id) {
         comboProductRepository.deleteById(id);
         return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
        return true;
    }

    @Override
    public List<ComboProduct> getAll() {
        return comboProductRepository.findAll();
    }
}
