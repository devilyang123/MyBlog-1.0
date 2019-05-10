package com.xiao.controller;

import com.xiao.common.TableResult;
import com.xiao.entity.Category;
import com.xiao.service.IAdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 后台管理 分类controller
 * @Auther: 笑笑
 * @Date: 15:35 2018/10/17
 */
@RestController
@RequestMapping(value = "/admin/category")
public class AdminCategoryController {

    @Autowired
    private IAdminCategoryService adminCategoryService;


    /**
     * @Description 查询所有分类
     * @Date 15:38 2018/10/17
     * @Param
     * @return
     */
    @GetMapping(value = "/findAll")
    public TableResult<Category> findAll(Integer page,Integer limit){
        System.out.println(adminCategoryService.findAll(page,limit));
        return adminCategoryService.findAll(page,limit);
    }

    /**
     * @Description 保存分类
     * @Date 16:26 2018/10/17 
     * @Param 
     * @return 
     */
    @PostMapping(value ="/save")
    public boolean save(Category category){
      return adminCategoryService.save(category);
    }
}
