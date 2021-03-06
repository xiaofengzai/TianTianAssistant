package com.tt.pojo.model;

import javax.persistence.*;

@Entity
public class PagePermission {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 页面主键
     */
    @Column(name = "page_id",updatable = false,length = 36)
    private String pageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id",insertable = false,updatable = false)
    private Page page;

    /**
     * 权限主键id
     */
    @Column(name = "permission_id",updatable = false,length = 36)
    private String permissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id",insertable = false,updatable = false)
    private Permission permission;



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pageId=").append(pageId);
        sb.append(", permissionId=").append(permissionId);
        sb.append("]");
        return sb.toString();
    }
}