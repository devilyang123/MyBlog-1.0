package com.xiao.repository;

import com.xiao.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description 后台管理 分类dao层接口
 * @Auther: 笑笑
 * @Date: 15:22 2018/10/17
 */
public interface AdminCategoryRepository extends JpaRepository<Category,Long> {

    @Override
    Page<Category> findAll(Pageable pageable);
}
