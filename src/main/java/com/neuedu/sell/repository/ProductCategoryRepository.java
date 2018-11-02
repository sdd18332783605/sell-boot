package com.neuedu.sell.repository;

import com.neuedu.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /*
    * 通过商品类别编号查询商品信息
    * */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
