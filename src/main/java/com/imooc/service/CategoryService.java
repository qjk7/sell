package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryId(List<Integer> categoryIdList);

    ProductCategory save(ProductCategory productCategory);
}
