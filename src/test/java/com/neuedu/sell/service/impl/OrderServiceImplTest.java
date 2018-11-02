package com.neuedu.sell.service.impl;

import com.neuedu.sell.dto.OrderDTO;
import com.neuedu.sell.entity.OrderDetail;
import com.neuedu.sell.entity.OrderMaster;
import com.neuedu.sell.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void create(){

        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("13333333333");
        orderDTO.setBuyerAddress("西七道");
        orderDTO.setBuyerOpenid("12345");
        List<OrderDetail> orderDetailList=new ArrayList<>();
        orderDetailList.add(new OrderDetail("1",2));
        orderDetailList.add(new OrderDetail("2",2));
        orderDTO.setOrderDetailList(orderDetailList);
        orderService.create(orderDTO);


    }

    @Test
    public void findOne(){
        System.out.println(
                orderService.findOne("1541157026424")
        );

    }
}