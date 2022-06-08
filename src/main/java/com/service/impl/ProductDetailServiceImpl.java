package com.service.impl;

import com.Utils.FileUploadProvider;
import com.entities.ProductDetail;
import com.entities.models.ProductDetailModel;
import com.repository.ProductDetailRepository;
import com.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductDetailServiceImpl implements IProductDetailService {
    private final ProductDetailRepository productDetailRepository;
    private final IBrandService brandService;
    private final ICountryService countryService;
    private final IUnitService unitService;
    private final IWeightService weightService;
    private final IProductService productService;
    private final ICategoryService categoryService;
    private final FileUploadProvider fileUploadProvider;

    public ProductDetailServiceImpl(ProductDetailRepository productDetailRepository, IBrandService brandService, ICountryService countryService, IUnitService unitService, IWeightService weightService, IProductService productService, ICategoryService categoryService, FileUploadProvider fileUploadProvider) {
        this.productDetailRepository = productDetailRepository;
        this.brandService = brandService;
        this.countryService = countryService;
        this.unitService = unitService;
        this.weightService = weightService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.fileUploadProvider = fileUploadProvider;
    }

    @Override
    public List<ProductDetail> findAll() {
        return null;
    }

    @Override
    public Page<ProductDetail> findAll(Pageable page) {
        return this.productDetailRepository.findAll(page);
    }

    @Override
    public Page<ProductDetail> findAll(Pageable page, Specification<ProductDetail> specifications) {
        return this.productDetailRepository.findAll(specifications, page);
    }

    @Override
    public ProductDetail findById(Long id) {
        return this.productDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found product detail id: " + id));
    }

    @Override
    public ProductDetail add(ProductDetailModel model) {
        ProductDetail entity = ProductDetailModel.toEntity(model);
        try {
            entity.setImage(fileUploadProvider.uploadFile("product", model.getImage()));
        } catch (IOException e) {
            throw new RuntimeException("cannot upload image");
        }
        entity.setBrand(this.brandService.findById(model.getBrand()));
        entity.setCountry(this.countryService.findById(model.getCountry()));
        entity.setUnit(this.unitService.findById(model.getUnit()));
        entity.setWeight(this.weightService.findById(model.getWeight()));
        entity.setProductParent(this.productService.findById(model.getProductParent()));
        entity.setCategory(this.categoryService.findById(model.getCategory()));
        return this.productDetailRepository.save(entity);
    }

    @Override
    public ProductDetail update(ProductDetailModel model) {
        return add(model);
    }

    @Override
    public boolean deleteById(Long id) {
        this.productDetailRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
        return true;
    }
}
