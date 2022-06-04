package com.service;

import java.util.List;

import com.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBaseService<T, M, K> {
    List<T> findAll();

    Page<T> findAll(Pageable page);

    T findById(K id);

    T add(M model);

    T update(M model);

    boolean deleteById(K id);
    boolean deleteByIds(List<K> id);
}