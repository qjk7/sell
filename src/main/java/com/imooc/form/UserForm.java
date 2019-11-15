package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author Sakura
 * @Date 1/8/2019
 **/

@Data
public class UserForm {

    @NotEmpty(message = "账号不能为空")
    String username;

    @NotEmpty(message = "密码不能为空")
    String password;
}
