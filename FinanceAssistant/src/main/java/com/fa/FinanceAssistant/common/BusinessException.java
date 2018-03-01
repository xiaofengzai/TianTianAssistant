package com.fa.FinanceAssistant.common;

import lombok.Data;

/**
 * Created by wenfeng on 2018/3/1.
 */
@Data
public class BusinessException extends RuntimeException {
    private Integer code=0;
    private String message;
    public BusinessException(String message){
        this(message,-1);
    }

    public BusinessException(String message ,Integer code){
        super(message);
        this.message =message;
        this.code =code;
    }
    @Override
    public String getMessage(){
        return message;
    }

}
