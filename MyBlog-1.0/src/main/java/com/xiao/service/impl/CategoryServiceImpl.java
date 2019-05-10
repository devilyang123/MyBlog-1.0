package com.xiao.service.impl;

import com.xiao.entity.Category;
import com.xiao.repository.CategoryRepository;
import com.xiao.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description 博客分类service层实现类
 * @Auther: 笑笑
 * @Date: 8:58 2018/10/8
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * @Description 查询所有分类
     * @Date 8:59 2018/10/8
     * @Param
     * @return
     */
    @Override
    public List<Category> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        if(!CollectionUtils.isEmpty(categoryList)){
            return categoryList;
        }
        return null;
    }

    /**
     * @Description 根据ID 查询分类
     * @Date 9:57 2018/10/8
     * @Param
     * @return
     */
    @Override
    public Category getOne(Long categoryId) {
        Category category = categoryRepository.findCategoryByCategoryId(categoryId);
        if(category != null){
            return category;
        }
        return null;
    }
}
