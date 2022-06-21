package com.service.impl;

import com.entities.Country;
import com.entities.models.CountryModel;
import com.repository.CountryRepository;
import com.service.ICountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {
private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Page<Country> findAll(Pageable page) {
        return this.countryRepository.findAll(page);
    }

    @Override
    public Page<Country> findAll(Pageable page, Specification<Country> specifications) {
        return this.countryRepository.findAll(specifications, page);
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found country id: " + id));
    }

    @Override
    public Country add(CountryModel model) {
        Country entity = CountryModel.toEntity(model);
        return this.countryRepository.save(entity);
    }

    @Override
    public Country update(CountryModel model) {
        Country original = this.findById(model.getCountryId());
        original.setCountryId(model.getCountryId());
        original.setCountryName(model.getCountryName());
        return this.countryRepository.save(original);
    }

    @Override
    public boolean deleteById(Long id) {
        this.countryRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
        return true;
    }
}
