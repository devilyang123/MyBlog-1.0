package com.xiao.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Description 博客分类实体类
 * @Auther: 笑笑
 * @Date: 11:19 2018/9/30
 */
@Data
@Entity(name = "tb_category")
public class Category {

    /**
     * 分类Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    /**
     * 分类名称
     */
    private String name;

}
