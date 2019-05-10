package com.xiao.service;

import com.xiao.common.TableResult;
import com.xiao.entity.Category;

/**
 * @Description 后台管理 分类service层接口
 * @Auther: 笑笑
 * @Date: 15:24 2018/10/17
 */
public interface IAdminCategoryService {

    /**
     * 查询所有分类
     * @return
     */
    TableResult<Category> findAll(Integer page,Integer limit);

    /**
     * 保存分类
     * @param category
     * @return
     */
    boolean save(Category category);
}
