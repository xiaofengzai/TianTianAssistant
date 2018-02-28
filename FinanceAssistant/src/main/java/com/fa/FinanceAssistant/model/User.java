package com.fa.FinanceAssistant.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wenfeng on 2018/2/28.
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

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
}
