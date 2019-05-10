package com.xiao.repository;

import com.xiao.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description 博客 dao接口
 * @Auther: 笑笑
 * @Date: 10:26 2018/9/26
 */
public interface BlogRepository extends JpaRepository<Blog,Long> {

    @Override
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByLogicEquals(Integer logic,Pageable pageable);

    //查询置顶博客
    Blog findBlogByIsTopEqualsAndLogicEquals(Integer isTop,Integer logic);
}
