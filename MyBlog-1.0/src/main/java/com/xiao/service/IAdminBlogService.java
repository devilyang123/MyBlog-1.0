package com.xiao.service;

import com.xiao.common.TableResult;
import com.xiao.entity.Blog;
import com.xiao.entity.Count;

import java.util.List;

/**
 * @Description 后台管理 博客serviceceng 接口
 * @Auther: 笑笑
 * @Date: 10:23 2018/10/18
 */
public interface IAdminBlogService {

    /**
     * 分页查询博客
     * @param page
     * @param limit
     * @return
     */
    TableResult<Blog> findAll(Integer page, Integer limit);

    /**
     * 保存博客（更新博客）
     * @param blog
     * @return
     */
    boolean save(Blog blog);

    /**
     * 通过ID查询博客
     * @param blogId
     * @return
     */
    Blog getOne(Long blogId);

    List<Blog> findBlobByIsTop(Integer isTop);

    /**
     * 查询总访问量
     * @param countId
     * @return
     */
    Count getCount();
}
