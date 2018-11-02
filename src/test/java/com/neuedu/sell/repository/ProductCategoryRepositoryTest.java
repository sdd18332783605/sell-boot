package com.neuedu.sell.repository;

import com.neuedu.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Test
    public void findAllTest(){
        List<ProductCategory> productCategoryList=categoryRepository.findAll();
        for (ProductCategory productCategory : productCategoryList) {
            System.out.println(productCategory);
        }
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("畅销榜");
        productCategory.setCategoryType(3);
        categoryRepository.save(productCategory);

    }

    @Test
    public void findBycategoryTypeTest(){
        List<Integer> typeList=Arrays.asList(1);
        List<ProductCategory> productCategoryList=categoryRepository.findByCategoryTypeIn(typeList);
        for (ProductCategory productCategory : productCategoryList) {
            System.out.println(productCategory);
        }
    }
}