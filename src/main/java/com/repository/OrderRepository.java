package com.repository;

import com.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository extends JpaRepository<Orders, String > , JpaSpecificationExecutor<Orders> {

}
