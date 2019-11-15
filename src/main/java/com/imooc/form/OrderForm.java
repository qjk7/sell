package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    //买家姓名
    @NotEmpty(message = "姓名不能为空")
    private String name;

    //手机号
    @NotEmpty(message = "手机号不能为空")
    private String phone;

    //地址
    @NotEmpty(message = "地址不能为空")
    private String address;

    //微信openid
    @NotEmpty(message = "openid不能为空")
    private String openid;

    //购物车
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
