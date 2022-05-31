package com.repository;

import com.entities.models.CTSanPhamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTSanPhamRepository extends JpaRepository<CTSanPhamModel,Integer> {

}

