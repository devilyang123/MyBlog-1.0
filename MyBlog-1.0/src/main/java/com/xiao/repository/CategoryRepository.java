package com.xiao.repository;

import com.xiao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description 博客分类dao层接口
 * @Auther: 笑笑
 * @Date: 8:55 2018/10/8
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findCategoryByCategoryId(Long categoryId);
}
