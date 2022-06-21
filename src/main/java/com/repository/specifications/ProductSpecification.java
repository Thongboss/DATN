package com.repository.specifications;

import com.entities.models.ProductFilterModel;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification extends BaseSpecification {

    public static Specification byId(Long id) {
        return (root, query, cb) -> cb.equal(root.get("id"), id);
    }

    public static Specification filter(ProductFilterModel model) {
        List<Specification> specs = new ArrayList<>();

        if (model.getId() != null) {
            specs.add(byId(model.getId()));
        }
        if (model.getProductName() != null) {
            specs.add(like("productName", model.getProductName()));
        }
        if (model.getDescription() != null) {
            specs.add(like("description", model.getDescription()));
        }

        Specification finalSpec = null;
        for (Specification spec : specs) {
            if (finalSpec == null) {
                finalSpec = spec;
            } else {
                finalSpec = finalSpec.and(spec);
            }
        }
        return finalSpec;

    }
}
