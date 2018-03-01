package com.fa.FinanceAssistant.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by wenfeng on 2018/3/1.
 */
@ApiModel
@Data
public class ResponseResult<T> {
    @ApiModelProperty(value = "返回的数据")
    private T data;
    @ApiModelProperty(value = "返回码，0为正常")
    private Integer code=0;
    @ApiModelProperty(value = "返回消息")
    private String message;

    ResponseResult() {
    }

    ResponseResult(T data) {
        this.data = data;
    }
    ResponseResult(T data,Integer code) {
       this(data);
       this.code=code;
    }
    ResponseResult(T data,Integer code,String message) {
        this(data,code);
        this.message=message;
    }
    public static ResponseResult SuccessResult(){
        return new ResponseResult();
    }

    public static <T> ResponseResult<T> SuccessResult(T data){
        return new ResponseResult(data);
    }
    public static ResponseResult FailResult(String message){
        return new ResponseResult(null, Constant.FAIL_CODE,message);
    }
    public static <T> ResponseResult<T> FailResult(String message,Integer code){
        return new ResponseResult(null,code,message);
    }
    public static <T> ResponseResult<T> FailResult(String message,Integer code,T data){
        return new ResponseResult(data,code,message);
    }
}
