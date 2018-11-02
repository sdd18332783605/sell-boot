package com.neuedu.sell.converter;

import com.neuedu.sell.dto.OrderDTO;
import com.neuedu.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

/**
 * OrderMaster转化成OrderDTO
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
}
