package com.xiao.controller;

import com.xiao.entity.Category;
import com.xiao.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description 博客分类controller
 * @Auther: 笑笑
 * @Date: 9:11 2018/10/8
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping(value = "/getOne")
    @ResponseBody
    public Category getOne(Long categoryId){
        return categoryService.getOne(categoryId);
    }
}
