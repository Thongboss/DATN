package com.repository;

import com.entities.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OriginRepository extends JpaRepository<Origin, Long>, JpaSpecificationExecutor<Origin> {
}
