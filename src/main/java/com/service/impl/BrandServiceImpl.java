package com.service.impl;

import com.entities.Brand;
import com.entities.models.BrandModel;
import com.repository.BrandRepository;
import com.service.IBrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return this.brandRepository.findAll();
    }

    @Override
    public Page<Brand> findAll(Pageable page) {
        return
                this.brandRepository.findAll(page);
    }

    @Override
    public Page<Brand> findAll(Pageable page, Specification<Brand> specifications) {
        return
                this.brandRepository.findAll(specifications, page);
    }

    @Override
    public Brand findById(Long id) {
        return this.brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found brand id: " + id));
    }

    @Override
    public Brand add(BrandModel model) {
        Brand entity = BrandModel.toEntity(model);
        return this.brandRepository.save(entity);
    }

    @Override
    public Brand update(BrandModel model) {
        Brand original = this.findById(model.getBrandId());
        original.setBrandId(model.getBrandId());
        original.setBrandName(model.getBrandName());
        return this.brandRepository.save(original);
    }

    @Override
    public boolean deleteById(Long id) {
        this.brandRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
        return true;
    }
}
