package com.service;


import com.entities.models.SanPham;

import java.util.List;

public interface SanPhamService {


    List<SanPham> getByDanhMuc(Integer id);
    List<SanPham> getByIds(List<Integer> ids);
}
