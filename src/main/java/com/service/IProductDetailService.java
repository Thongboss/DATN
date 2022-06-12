package com.service;

import com.entities.ProductDetail;
import com.entities.models.ProductDetailModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductDetailService extends IBaseService<ProductDetail, ProductDetailModel, Long> {

    Page<ProductDetail> search(String keyword, Pageable page);
}
