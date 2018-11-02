package com.neuedu.sell.service;

import com.neuedu.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 根据订单ID查询单个订单信息
     * @param orderId
     * @return
     */
    OrderDTO findOne(String orderId);

    /**
     * 根据微信openID查询订单列表
     * @param buyerOpenid
     * @return
     */
    Page<OrderDTO> findlist(String buyerOpenid);

    /**
     * 取消订单
     * @param orderDTO
     * @return
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完成订单
     * @param orderDTO
     * @return
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 已支付订单
     * @param orderDTO
     * @return
     */
    OrderDTO paid(OrderDTO orderDTO);


}
