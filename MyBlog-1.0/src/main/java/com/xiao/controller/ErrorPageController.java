package com.xiao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @Description 错误页面控制器
 * @Auther: 笑笑
 * @Date: 11:13 2018/10/16
 */
@Controller
public class ErrorPageController {

    @GetMapping(value = "/403")
    public String error_403(){
        return "403";
    }

    @GetMapping(value = "/404")
    public String error_404(){
        return "404";
    }

    @GetMapping(value = "/500")
    public String error_500(){
        return "500";
    }
}
