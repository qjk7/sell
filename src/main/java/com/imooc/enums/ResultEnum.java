package com.imooc.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数错误"),

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不足"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付失败"),
    CART_EMPTY(18,"购物车为空"),

    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),
    ORDER_FINISH_SUCCESS(23,"订单完结成功"),
    PRODUCT_STATUS_ERROR(24, "商品状态不正确"),
    LOGIN_FAIL(25,"登陆失败，信息不正确"),
    LOGOUT_SUCCESS(2,"登出成功"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
