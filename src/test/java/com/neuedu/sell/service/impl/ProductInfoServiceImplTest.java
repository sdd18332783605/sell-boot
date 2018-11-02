package com.neuedu.sell.service.impl;

import com.neuedu.sell.entity.ProductInfo;
import com.neuedu.sell.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findUpAll(){
        for (ProductInfo productInfo : productInfoService.findUpAll()) {
            System.out.println(productInfo);
        }
    }
}