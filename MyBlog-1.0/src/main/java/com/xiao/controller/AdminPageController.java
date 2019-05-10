package com.xiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 管理端页面跳转
 * @Auther: 笑笑
 * @Date: 11:52 2018/10/17
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminPageController {

    /**
     * @Description 管理端首页跳转
     * @Date 11:53 2018/10/17
     * @Param
     * @return
     */
    @GetMapping(value = "/index")
    public String index(){
        return "/admin/index";
    }

    /**
     * @Description 管理端主页跳转
     * @Date 11:45 2018/11/6
     * @Param
     * @return
     */
    @GetMapping(value = "/home")
    public String home(){
        return "/admin/home";
    }
    /**
     * @Description 分类管理页面跳转
     * @Date 14:45 2018/10/17
     * @Param
     * @return
     */
    @GetMapping(value = "/category/categoryManage")
    public String category(){
        return "/admin/category/categoryManage";
    }

    /**
     * @Description 添加分类页面跳转
     * @Date 14:45 2018/10/17
     * @Param
     * @return
     */
    @GetMapping(value = "/category/addPage")
    public String add_category(){
        return "/admin/category/addPage";
    }

    /**
     * @Description 博客管理页面跳转
     * @Date 10:42 2018/10/18
     * @Param
     * @return
     */
    @GetMapping(value = "/blog/blogManage")
    public String blog(){
        return "/admin/blog/blogManage";
    }

    /**
     * @Description 用户管理页面跳转
     * @Date 11:17 2018/10/18
     * @Param
     * @return
     */
    @GetMapping(value = "/user/userManage")
    public String user(){
        return "/admin/user/userManage";
    }
}
