package com.tt.pojo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Page {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 页面元素编码
     */
    @Column(name = "page_code")
    private String pageCode;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pageId=").append(id);
        sb.append(", pageCode=").append(pageCode);
        sb.append("]");
        return sb.toString();
    }
}