package com.service;

import java.util.List;

import com.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface IBaseService<T, M, K> {
    List<T> findAll();

    Page<T> findAll(Pageable page);
    Page<T> findAll(Pageable page, Specification<T> specifications);

    T findById(K id);

    T add(M model);

    T update(M model);

    boolean deleteById(K id);
    boolean deleteByIds(List<K> id);
}