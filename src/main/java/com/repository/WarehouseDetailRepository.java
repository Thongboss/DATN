package com.repository;

import com.entities.WarehouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WarehouseDetailRepository extends JpaRepository<WarehouseDetail, Long> {

    @Query("SELECT sum(wd.quantity) FROM WarehouseDetail wd WHERE wd.productDetailId = ?1")
    Integer sumAllQuantityProduct(Long productID);
}
