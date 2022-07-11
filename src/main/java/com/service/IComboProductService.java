package com.service;

import com.entities.ComboProduct;
import com.entities.models.ComboProductModel;

import java.util.List;

public interface IComboProductService extends IBaseService<ComboProduct, ComboProductModel, Long>{

    List<ComboProduct> getAll();
}
