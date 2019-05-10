package com.xiao.repository;

import com.xiao.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @Description 后台管理 博客dao接口
 * @Auther: 笑笑
 * @Date: 10:21 2018/10/18
 */
public interface AdminBlogRepository extends JpaRepository<Blog,Long> {

    @Override
    Page<Blog> findAll(Pageable pageable);

    //根据置顶标识查询博客
    List<Blog> findBlogByIsTopEquals(Integer isTop);
}
