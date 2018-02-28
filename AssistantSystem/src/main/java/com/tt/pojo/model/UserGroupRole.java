package com.tt.pojo.model;

import javax.persistence.*;

@Entity
public class UserGroupRole  {
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
     * 角色主键
     */
    @Column(name = "role_id",updatable = false,length = 36)
    private String roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private Role role;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userGroupId=").append(userGroupId);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}