package com.neuedu.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    QUANTITY_NOT_LOGEL(11,"商品数量不合法"),
    STOCK_NOT_ENOUGH(12,"商品库存不足"),
    ORDER_NOT_EXIST(13,"点餐不存在"),
    ORDERDETAIL_NOT_EXIST(14,"订单详情不存在");
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
