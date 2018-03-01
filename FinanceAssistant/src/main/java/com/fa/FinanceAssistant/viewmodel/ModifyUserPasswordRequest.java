package com.fa.FinanceAssistant.viewmodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by wenfeng on 2018/2/28.
 */
@ApiModel
@Data
public class ModifyUserPasswordRequest {
    @ApiModelProperty(value = "旧密码")
    private String oldPassword;
    @ApiModelProperty(value = "新密码")
    private String newPassword;
}
