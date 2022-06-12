package com.service.impl;

import com.Utils.SecurityUtils;
import com.entities.ProductDetail;
import com.entities.Warehouse;
import com.entities.WarehouseDetail;
import com.entities.models.WarehouseDetailModel;
import com.entities.models.WarehouseModel;
import com.repository.ProductDetailRepository;
import com.repository.UserRepository;
import com.repository.WarehouseDetailRepository;
import com.repository.WarehouseRepository;
import com.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class WarehouseServiceImpl implements IWarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    WarehouseDetailRepository warehouseDetailRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public List<Warehouse> findAll() {
        return null;
    }

    @Override
    public Page<Warehouse> findAll(Pageable page) {
        return this.warehouseRepository.findAll(page);
    }

    @Override
    public Page<Warehouse> findAll(Pageable page, Specification<Warehouse> specifications) {
        return null;
    }

    @Override
    public Warehouse findById(Long id) {
        return this.warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found warehouse!"));
    }

    @Override
    public Warehouse add(WarehouseModel model) {
        final Warehouse warehouse = modelToEntityWarehouse(model); // convert lai tu model sang entity

        List<Long> productDetailIds = new ArrayList<>();
        AtomicReference<Integer> totalQuantity = new AtomicReference<>(0);
        warehouse.setWarehouseDetails(model.getWarehouseDetails().stream().map(dt ->
        {
            WarehouseDetail warehouseDetail = modelToEntityWarehouseDetail(dt);
            warehouseDetail.setWarehouse(warehouse);
            productDetailIds.add(dt.getProductDetailId());
            totalQuantity.updateAndGet(v -> v + dt.getQuantity());
            return warehouseDetail;
        }).collect(Collectors.toList()));
        warehouse.setTotalQuantity(totalQuantity.get());
        Warehouse savedWarehouse = this.warehouseRepository.save(warehouse);

        // set product quantity
        productDetailIds.forEach(id -> {
            ProductDetail p = productDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found product detail!"));
            p.setProductRemain(this.warehouseDetailRepository.sumAllQuantityProduct(id));
            this.productDetailRepository.save(p);
        });
        return savedWarehouse;
    }

    @Override
    public Warehouse update(WarehouseModel model) {
        return this.add(model);
    }

    @Override
    public boolean deleteById(Long id) {
        this.warehouseRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> id) {
        return false;
    }

    public Warehouse modelToEntityWarehouse(WarehouseModel warehouseModel) {
        if (warehouseModel == null) throw new RuntimeException("WarehouseModel is null");
        return Warehouse.builder()
                .id(warehouseModel.getId())
                .description(warehouseModel.getDescription())
                .sumMoney(warehouseModel.getSumMoney())
                .user(SecurityUtils.getCurrentUser().getUser())
                .build();

    }

    public WarehouseDetail modelToEntityWarehouseDetail(WarehouseDetailModel model) {
        if (model == null) throw new RuntimeException("WarehouseModel is null");
        return WarehouseDetail.builder()
                .id(model.getId())
                .quantity(model.getQuantity())
                .price(model.getPrice())
                .dateOfManufacture(model.getDateOfManufacture())
                .expiry(model.getExpiry())
                .productDetailId(model.getProductDetailId())
                .build();

    }
}
