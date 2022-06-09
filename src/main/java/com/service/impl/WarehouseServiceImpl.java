package com.service.impl;

import com.Utils.SecurityUtils;
import com.entities.ProductDetail;
import com.entities.User;
import com.entities.Warehouse;
import com.entities.WarehouseDetail;
import com.entities.models.UserModel;
import com.entities.models.WarehouseDetailModel;
import com.entities.models.WarehouseModel;
import com.repository.ProductDetailRepository;
import com.repository.UserRepository;
import com.repository.WarehouseDetailRepository;
import com.repository.WarehouseRepository;
import com.service.IProductDetailService;
import com.service.IWarehouseService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Warehouse warehouse = model.getId() != null ? this.findById(model.getId()) : modelToEntityWarehouse(model); // convert lai tu model sang entity
        warehouse.setWarehouseDetails(model.getWarehouseDetails().stream().map(dt ->
        {
            WarehouseDetail warehouseDetail = modelToEntityWarehouseDetail(dt);
            warehouseDetail.setWarehouse(warehouse);
            ProductDetail p = this.productDetailRepository.findById(dt.getProductDetailId()).orElseThrow(() -> new RuntimeException("Not found product detail!"));

            if (model.getId() != null && warehouseDetail.getId() != null) {
                WarehouseDetail w = getWarehouseDetail(dt.getId(), warehouse.getWarehouseDetails());
                if (w.getQuantity() > dt.getQuantity())
                    p.setProductRemain(p.getProductRemain() - (w.getQuantity() - dt.getQuantity()));
                else
                    p.setProductRemain(p.getProductRemain() + (dt.getQuantity() - w.getQuantity()));
            } else
                p.setProductRemain(p.getProductRemain() + dt.getQuantity());
            this.productDetailRepository.save(p);
            return warehouseDetail;
        }).collect(Collectors.toList()));
        return this.warehouseRepository.save(warehouse);
    }

    private WarehouseDetail getWarehouseDetail(Long id, List<WarehouseDetail> list) {
        return list.stream().filter(dt -> dt.getId() != id).findFirst().orElseThrow(() -> new RuntimeException("Not found warehouse detail!"));
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
                .dateWarehouse(warehouseModel.getDateWarehouse())
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
