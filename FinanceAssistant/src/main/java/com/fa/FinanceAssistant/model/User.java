package com.fa.FinanceAssistant.model;

import com.fa.FinanceAssistant.util.UUIDUtils;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by wenfeng on 2018/2/28.
 */
@Entity
@Data
public class User {
    @Id
    @Column
    private String id= UUIDUtils.generateOrderedUUID();

    /**
     * 用户名电话号码
     */
    @Column(length = 11)
    private String username;

    /**
     * 用户昵称
     */
    @Column(length =127)
    private String nickname;

    /**
     * 密码
     */
    @Column(length = 127)
    private String password;

    @Column
    private Boolean enable=Boolean.TRUE;
}
