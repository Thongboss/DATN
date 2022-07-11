package com.repository;

import com.entities.ComboProduct;
import com.entities.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface ComboProductRepository extends JpaRepository<ComboProduct, Long>, JpaSpecificationExecutor<ComboProduct> {

}
