package com.tt.pojo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserGroupUser {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户组
     */
    @Column(name = "user_group_id",updatable = false,length = 36)
    private String userGroupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_group_id",insertable = false,updatable = false)
    private UserGroup userGroup;

    /**
     * 用户

     */
    @Column(name = "user_id",updatable = false,length = 36)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userGroupId=").append(userGroupId);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}