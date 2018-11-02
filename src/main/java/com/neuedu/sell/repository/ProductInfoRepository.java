package com.neuedu.sell.repository;

import com.neuedu.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    /*
    * 根据商品状态查询商品信息
    * */
    public List<ProductInfo> findByProductStatus(Integer productStatus);


}
