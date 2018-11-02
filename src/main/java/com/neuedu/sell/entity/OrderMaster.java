package com.neuedu.sell.entity;

import com.neuedu.sell.enums.OrderStatusEnum;
import com.neuedu.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 */
@Data
@Entity
public class OrderMaster {
    @Id
    private String orderId;
    /* 买家姓名 */
    private String buyerName;
    /* 买家电话 */
    private String buyerPhone;
    /* 买家地址 */
    private String buyerAddress;
    /* 买家微信openid */
    private String buyerOpenid;
    /* 订单总金额 */
    private BigDecimal orderAmount;
    /* 订单状态 0 新下单，1已完成*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /* 支付状态 0 未支付，1 已下单*/
    private Integer payStatus = PayStatusEnum.NOT_PAY.getCode();
    /* 创建时间 */
    private Date createTime;
    /* 更新时间 */
    private Date updateTime;
}
