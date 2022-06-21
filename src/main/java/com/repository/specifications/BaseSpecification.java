package com.repository.specifications;

import org.springframework.data.jpa.domain.Specification;

public abstract class BaseSpecification {

    public static Specification like(String field, String q){
        return (root, query, cb) -> cb.like(root.get(field), "%" + q + "%");
    }
}
