package com.service;

import com.entities.ComboDetail;
import com.entities.ComboProduct;
import com.entities.models.ComboDetailModel;

import java.util.List;

public interface IComboDetailService extends IBaseService<ComboDetail, ComboDetailModel, Long>{

    List<ComboDetail> getAll();
}
