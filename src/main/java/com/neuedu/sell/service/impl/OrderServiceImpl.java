package com.neuedu.sell.service.impl;

import com.neuedu.sell.converter.OrderMaster2OrderDTOConverter;
import com.neuedu.sell.dto.CartDTO;
import com.neuedu.sell.dto.OrderDTO;
import com.neuedu.sell.entity.OrderDetail;
import com.neuedu.sell.entity.OrderMaster;
import com.neuedu.sell.entity.ProductInfo;
import com.neuedu.sell.enums.ResultEnum;
import com.neuedu.sell.exception.SellException;
import com.neuedu.sell.repository.OrderDetailRepository;
import com.neuedu.sell.repository.OrderMasterRepository;
import com.neuedu.sell.service.OrderService;
import com.neuedu.sell.service.ProductInfoService;
import com.neuedu.sell.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        //生成ID
        String orderId=KeyUtils.generateUniqueKey();

        //创建总价对象
        BigDecimal orderAmount=new BigDecimal(BigInteger.ZERO);
        //1.查询商品
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {

            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                //抛一个见名知意的异常（spring中有个全局捕获异常技术，将异常抛给它，用它来处理异常）
                //商品不存在
               new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算总价
            orderAmount = orderAmount.add(productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))) ;
           //订单详情
           //设置订单ID
            orderDetail.setOrderId(orderId);
           //设置此数据的ID
           orderDetail.setDetailId(KeyUtils.generateUniqueKey());
           //复制商品信息
            BeanUtils.copyProperties(productInfo,orderDetail);
          //将数据插入到数据库中
            orderDetailRepository.save(orderDetail);
        }

        //3.数据入库
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);
        //4.扣库存
        List<CartDTO> cartDTOList=new ArrayList<>();
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            cartDTOList.add(new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity()));
        }
        productInfoService.decreaseStock(cartDTOList);
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster=orderMasterRepository.findOne(orderId);
        //判断是否真的有点餐
        if (orderMaster == null){
            new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        //判断订单详情是否为空
        if (orderDetailList.size() == 0){
            new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        //将orderMaster和orderDetailList数据添加到OrderDTO
        OrderDTO orderDTO = OrderMaster2OrderDTOConverter.convert(orderMaster);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findlist(String buyerOpenid) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
