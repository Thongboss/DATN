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
        ProductDetail entity = model.getProductDetailId() != null ? this.findById(model.getProductDetailId()) : ProductDetailModel.toEntity(model);
        entity.setBrand(this.brandService.findById(model.getBrand()));
        entity.setCountry(this.countryService.findById(model.getCountry()));
        entity.setStatus(true);
        entity.setUnit(this.unitService.findById(model.getUnit()));
        entity.setWeight(this.weightService.findById(model.getWeight()));
        entity.setProductParent(this.productService.findById(model.getProductParent()));
        entity.setCategory(this.categoryService.findById(model.getCategory()));
        entity.setProductRemain(entity.getProductDetailId() == null ? 0 : entity.getProductRemain());
        entity = this.productDetailRepository.save(entity);

        try {
            if (model.getImage() != null) {
                if (entity.getImage() != null)
                    this.fileUploadProvider.deleteFile(entity.getImage());
                entity.setImage(fileUploadProvider.uploadFile("product/".concat(entity.getProductDetailId().toString()), model.getImage()));
            }
        } catch (IOException e) {
            throw new RuntimeException("cannot upload image");
        }

        return this.productDetailRepository.save(entity);
    }

    @Override
    public ProductDetail update(ProductDetailModel model) {
        return add(model);
    }

    @Override
    public boolean deleteById(Long id) {
        ProductDetail en = this.findById(id);
        en.setStatus(false);
        this.productDetailRepository.save(en);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
        return true;
    }

    @Override
    public Page<ProductDetail> search(String keyword, Pageable page) {
        return this.productDetailRepository.search(keyword, page);
    }
}
