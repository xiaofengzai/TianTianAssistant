package com.fa.FinanceAssistant.viewmodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by wenfeng on 2018/2/28.
 */
@ApiModel
@Data
public class ResetUserPasswordRequest {
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "新密码")
    private String password;
    @ApiModelProperty(value = "验证码")
    private String validationCode;
}
