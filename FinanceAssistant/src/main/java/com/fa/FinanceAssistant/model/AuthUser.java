package com.fa.FinanceAssistant.model;

import lombok.Data;

/**
 * Created by wenfeng on 2018/3/2.
 */
@Data
public class AuthUser  {
    private String username;

    private String password;

    public AuthUser() {
    }
}
