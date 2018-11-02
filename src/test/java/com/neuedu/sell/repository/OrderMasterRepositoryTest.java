package com.neuedu.sell.repository;

import com.neuedu.sell.entity.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

      @Test
      public void findByBuyerOpenid(){
          Pageable pageable=new PageRequest(0,2);
          Page<OrderMaster> orderMasterPage =orderMasterRepository.findByBuyerOpenid("1234567",pageable);
          for (OrderMaster orderMaster : orderMasterPage.getContent()) {
              System.out.println(orderMaster);
          }
      }
}