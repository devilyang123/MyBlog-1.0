package com.xiao.service.impl;

import com.xiao.Utils.TableResultUtils;
import com.xiao.common.TableResult;
import com.xiao.entity.Category;
import com.xiao.repository.AdminCategoryRepository;
import com.xiao.service.IAdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Description 后台管理 分类service层接口实现类
 * @Auther: 笑笑
 * @Date: 15:27 2018/10/17
 */
@Service
public class AdminCategoryServiceImpl implements IAdminCategoryService {

    @Autowired
    private AdminCategoryRepository adminCategoryRepository;

    /**
     * 查询所有分类
     * @return
     */
    @Override
    public TableResult<Category> findAll(Integer page,Integer limit) {
        Pageable pageable = PageRequest.of(page-1,limit);//springboot2.0新分页方法
        Page<Category> categories = adminCategoryRepository.findAll(pageable);
        TableResult<Category> result = new TableResult<>();
        TableResultUtils.result(categories,result);
        return result;
    }

    /**
     * @Description 保存分类
     * @Date 16:22 2018/10/17 
     * @Param 
     * @return 
     */
    @Override
    public boolean save(Category category) {
        Category result = adminCategoryRepository.save(category);
        if(result != null){
            return true;
        }
        return false;
    }
}
