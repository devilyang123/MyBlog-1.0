package com.xiao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description 博客实体类
 * @Auther: 笑笑
 * @Date: 10:22 2018/9/26
 */
@Data
@Entity(name = "tb_blog")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class Blog implements Serializable {

    /**
     * 博客Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;

    /**
     * 博客标题
     */
    @NotNull
    private String title;

    /**
     * 阅读量
     */
    @Column(columnDefinition = "INT default 0")
    private Integer readNum = 0;

    /**
     * 评论量
     */
    @Column(columnDefinition = "INT default 0")
    private Integer comments = 0;

    /**
     * 博客分类Id
     */
    private Long categoryId;

    /**
     * 博客分类名称
     */
    private String categoryName;

    /**
     * 摘要
     */
    private String summary_;

    /**
     * 博客内容
     */
    @Lob
    private String content;

    /**
     * 博客图片名称
     */
    private String imgUrl;

    /**
     * 博客置顶标识 默认0-不置顶，1-置顶
     */
    @Column(columnDefinition = "INT default 0")
    private Integer isTop = 0;

    /**
     * 删除标识  0-正常 1-删除
     */
    @Column(columnDefinition = "INT default 0")
    private Integer logic = 0;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}
