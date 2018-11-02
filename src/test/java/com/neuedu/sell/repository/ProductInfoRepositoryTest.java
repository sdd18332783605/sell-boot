package com.neuedu.sell.repository;

import com.neuedu.sell.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void save(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("1001");
        productInfo.setProductName("面条");
        productInfo.setProductPrice(new BigDecimal(23));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃");
        productInfo.setCategoryType(1);
        productInfoRepository.save(productInfo);
        System.out.println(productInfo);
    }

    @Test
    public void findAllTest(){
      List<ProductInfo> productInfoList= productInfoRepository.findAll();
        for (ProductInfo productInfo : productInfoList) {
            System.out.println(productInfo);
        }
    }

    @Test
    public void findAll(){

        //定义一个pageable对象
        Pageable pageable=new PageRequest(0,2);

        for (ProductInfo productInfo : productInfoRepository.findAll(pageable)) {
            System.out.println(productInfo);
        }
    }

}