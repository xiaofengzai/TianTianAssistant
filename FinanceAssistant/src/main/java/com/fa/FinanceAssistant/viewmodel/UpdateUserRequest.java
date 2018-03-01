package com.fa.FinanceAssistant.viewmodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by wenfeng on 2018/2/28.
 */
@ApiModel
@Data
public class UpdateUserRequest {
    @ApiModelProperty(value = "昵称")
    private String nickname;
}
