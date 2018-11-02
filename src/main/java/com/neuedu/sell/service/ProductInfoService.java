package com.neuedu.sell.service;

import com.neuedu.sell.dto.CartDTO;
import com.neuedu.sell.entity.OrderDetail;
import com.neuedu.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductInfoService {

   /*
   * 查询所有在架商品
   * */
    List<ProductInfo> findUpAll();

    /*
    *
    * 根据Id查询商品信息
    * */
    ProductInfo findOne(String productId);

    /*
    * 查询所有商品信息包括分页
    * */
    Page<ProductInfo> findAll(Pageable pageable);
    /*
    * 保存和修改商品信息
    * */
    ProductInfo save(ProductInfo productInfo);

 /**
  * 减少库存
  * @param cartDTOList
  */
 void decreaseStock(List<CartDTO> cartDTOList);

 /**
  * 增加库存
  * @param cartDTOList
  */
 void increaseStock(List<CartDTO> cartDTOList);


}
