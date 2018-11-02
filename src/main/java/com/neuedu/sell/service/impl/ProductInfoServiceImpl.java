package com.neuedu.sell.service.impl;

import com.neuedu.sell.dto.CartDTO;
import com.neuedu.sell.entity.OrderDetail;
import com.neuedu.sell.entity.ProductInfo;
import com.neuedu.sell.enums.ProductStatusEnum;
import com.neuedu.sell.enums.ResultEnum;
import com.neuedu.sell.exception.SellException;
import com.neuedu.sell.repository.ProductInfoRepository;
import com.neuedu.sell.service.ProductInfoService;
import com.neuedu.sell.utils.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList) {
            //获得该商品信息
            ProductInfo productInfo=productInfoRepository.findOne(cartDTO.getProductId());
            //判断商品是否存在
            if (productInfo == null){
                new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //判断商品数量是否合法
            if (cartDTO.getProductQuantity() <=0){
                new SellException(ResultEnum.QUANTITY_NOT_LOGEL);
            }
            //判断商品库存是否足够
            if (cartDTO.getProductQuantity()<productInfo.getProductStock()){
                new SellException(ResultEnum.STOCK_NOT_ENOUGH);
            }

            //扣库存
              //原库存数量减去购买数量
            productInfo.setProductStock(productInfo.getProductStock()-cartDTO.getProductQuantity());
              //将更改的商品，更新到数据库
            productInfoRepository.save(productInfo);
        }

    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }
}
