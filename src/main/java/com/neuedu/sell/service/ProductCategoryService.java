package com.neuedu.sell.service;

import com.neuedu.sell.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /*
    * 查询所有商品类别信息
    * */
     List<ProductCategory> findAll();
    /*
    * 根据商品类别ID查询商品类别信息
    * */
     ProductCategory findOne(Integer categoryId);

    /*
     * 通过商品类别编号查询商品类别信息
     * */
     List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
