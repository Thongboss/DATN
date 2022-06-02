package com.repository;

import com.entities.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WeightRepository extends JpaRepository<Weight, Long>, JpaSpecificationExecutor<Weight> {
}
