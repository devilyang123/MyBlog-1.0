package com.xiao.controller;

import com.xiao.Utils.GetIpUtils;
import com.xiao.entity.Count;
import com.xiao.service.IBlogService;
import com.xiao.service.ICountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description 页面跳转
 * @Auther: 笑笑
 * @Date: 17:03 2018/9/24
 */
@Controller
public class PageController {

    @Autowired
    private ICountService countService;

    @Autowired
    private IBlogService blogService;


    /**
     * @Description 首页跳转
     * @Date 17:32 2018/9/26
     * @Param
     * @return
     */
    @GetMapping(value = {"/","/index"})
    public String index(HttpSession session){
        Count count = countService.getOne((long) 1);
        Long total = (long)0;
        if(blogService.findAll() != null){
            total = (long)blogService.findAll().size();
        }
        Long num = count.getCount();
        num+=1;
        session.setAttribute("num",num);//访问量
        session.setAttribute("total",total);//博客总数
        count.setCount(num);
        countService.save(count);
        return "index";
    }

    /**
     * @Description 登录页面跳转
     * @Date 10:16 2018/9/30
     * @Param
     * @return
     */
    @GetMapping(value = "/login")
    public String login(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.getSession().removeAttribute("error");
        return "login";
    }

    /**
     * @Description 注册页面跳转
     * @Date 10:17 2018/9/30 
     * @Param 
     * @return 
     */
    @GetMapping(value = "/registerPage")
    public String registerPage(){
        return "registerPage";
    }

    /**
     * @Description 跳转文章列表
     * @Date 9:51 2018/10/8
     * @Param
     * @return
     */
    @GetMapping(value = "/blog/list")
    public String showBlogList(HttpSession session){
        Long total = (long)0;
        if(blogService.findAll() != null){
            total = (long)blogService.findAll().size();
        }
        session.setAttribute("total",total);//博客总数
        return "/blog/list";
    }

    /**
     * @Description 跳转写博客页面
     * @Date 14:19 2018/10/16
     * @Param
     * @return
     */
    @GetMapping(value = "/blog/writeBlog")
    public String showWriteBlobPage(){
        return "/blog/writeBlog";
    }

//    @GetMapping("/blog/editPage")
//    public String showEditPage(){
//        return "/blog/write"
//    }
}
