package com.fa.FinanceAssistant.viewmodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by wenfeng on 2018/2/28.
 */
@ApiModel
@Data
public class RegisterUserRequest extends UpdateUserRequest{
    @ApiModelProperty(value = "账号，建议是电话号码")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;
}
