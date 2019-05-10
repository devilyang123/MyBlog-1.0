package com.xiao.service;

import com.xiao.common.PageResult;
import com.xiao.entity.Blog;
import java.util.List;

/**
 * @Description 博客service层 接口
 * @Auther: 笑笑
 * @Date: 10:54 2018/9/27
 */
public interface IBlogService {

    /**
     * 保存博客接口
     * @param blog
     * @return
     */
    boolean save(Blog blog);

    /**
     * 根据博客ID查询博客
     * @param blogId
     * @return
     */
    Blog getOne(Long blogId);

    /**
     * 分页查询所有博客
     * @return
     */
    PageResult<Blog> findAll(int page, int size);

    /**
     * 查询所有博客
     * @return
     */
    List<Blog> findAll();

    /**
     * 查询热门博客（按阅读量）
     * @return
     */
    PageResult<Blog> findHotBlog();

    //查询置顶博客
    Blog findTopBlog();

    //修改博客
    public boolean editBlog(Blog blog);
}
