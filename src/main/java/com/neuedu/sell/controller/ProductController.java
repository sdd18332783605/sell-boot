package com.neuedu.sell.controller;

import com.neuedu.sell.VO.ProductCategoryVO;
import com.neuedu.sell.VO.ProductInfoVO;
import com.neuedu.sell.VO.ResultVO;
import com.neuedu.sell.entity.ProductCategory;
import com.neuedu.sell.entity.ProductInfo;
import com.neuedu.sell.service.ProductCategoryService;
import com.neuedu.sell.service.ProductInfoService;
import com.neuedu.sell.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/buyer/product")
public class ProductController {
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     *根据API拼接数据，返回商品列表
     * @return
     */
    @GetMapping("/list")
    public ResultVO list(){
        //1.查询出所有在架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2.根据商品查询对应的商品类别
        // 2.1构建商品类别种类的集合
        List<Integer> categoryTypeList=new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        // 2.2 根据商品类别编号查询所有商品类别
        List<ProductCategory> productCategoryList=productCategoryService.findByCategoryTypeIn(categoryTypeList);
       //3.数据拼装
        List<ProductCategoryVO> productCategoryVOList=new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
          //构建VO对象
            ProductCategoryVO productCategoryVO=new ProductCategoryVO();
          //将原数据对象赋给VO对象,spring中有BeanUtils类，可以将名字相同的属性对应过去
            BeanUtils.copyProperties(productCategory,productCategoryVO);
            /*productCategoryVO.setCategoryName(productCategory.getCategoryName());
            productCategoryVO.setCategoryType(productCategory.getCategoryType());*/
            //将原数据转化成VO集合
            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productCategoryVO.setFoods(productInfoVOList);
          //将VO对象添加到集合中
            productCategoryVOList.add(productCategoryVO);
        }
        return ResultVOUtils.success(productCategoryVOList);
    }


}
