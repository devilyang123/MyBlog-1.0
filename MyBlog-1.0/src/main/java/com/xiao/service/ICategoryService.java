package com.xiao.service;

import com.xiao.entity.Category;

import java.util.List;

/**
 * @Description 博客分类service层接口
 * @Auther: 笑笑
 * @Date: 8:57 2018/10/8
 */
public interface ICategoryService {

    /**
     * 查询所有分类
     * @return
     */
    List<Category> findAll();

    /**
     * 根据ID 查询分类
     * @param categoryId
     * @return
     */
    Category getOne(Long categoryId);
}
