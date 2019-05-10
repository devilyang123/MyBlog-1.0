package com.xiao.controller;


import com.xiao.Utils.MailUtils;
import com.xiao.entity.User;
import com.xiao.enums.CommonEnum;
import com.xiao.exception.AccountUnActiveException;
import com.xiao.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



/**
 * @Description 用户controller
 * @Auther: 笑笑
 * @Date: 21:15 2018/9/24
 */
@Controller
@Slf4j
public class UserController {


    @Autowired
    private IUserService userService;

    @Autowired
    private MailUtils mailUtils;

    /**
     * 激活链接url前缀
     */
    @Value("${user.active.url.prefix}")
    private String urlPrefix;

    /**
     * @Description 用户登录
     * @Date 8:36 2018/9/25
     * @Param
     * @return
     */
    @PostMapping(value = "/checkUser")
    public String checkUser(String username,String password){

        //获取当前主体
        Subject currentUser = SecurityUtils.getSubject();
        //判断主体是否认未证
        if(!currentUser.isAuthenticated()){
            //未认证 封装为token对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //记住我
            token.setRememberMe(false);
            Session session = currentUser.getSession(true);
            if(username == null || username.equals("") || password == null || password.equals("")){
                session.setAttribute("error","用户名或密码不能为空！");
                log.error("登录失败：用户名或密码为空！");
                return "login";
            }
            try {
                //执行登录
                currentUser.login(token);
            }catch (UnknownAccountException ue){
                session.setAttribute("error",ue.getMessage());
                log.error("登录失败：用户不存在！");
                return "login";
            }catch (AccountUnActiveException aue){
                session.setAttribute("error",aue.getMessage());
                log.error("登录失败：用户未激活！");
                return "login";
            }catch (IncorrectCredentialsException ie){
                session.setAttribute("error","登录失败:密码错误！");
                log.error("登录失败：密码错误！");
                return "login";
            }catch (AuthenticationException ae){  //所有认证时异常的父类
                session.setAttribute("error","登录失败:未知异常，必要时请联系站长！");
                log.error("登录失败：未知异常！");
                return "login";
            }
        }
        return "redirect:/index";
    }

    /**
     * @Description 用户注册
     * @Date 8:52 2018/9/25
     * @Param
     * @return
     */
    @PostMapping(value = "/register")
    public String register(User user){
        userService.save(user);
        String link = "<a target='_blank' style='text-decoration:none;' " +
                "href='"+urlPrefix+"active/"+user.getUserName()+"'>请点击这里进行账号激活</a>";
        mailUtils.sendHtmlMail(user.getEmail(),link);//发送激活邮件
        Subject currentUser = SecurityUtils.getSubject();
        //注册成功，跳转登录页面之前销毁session
        currentUser.getSession().stop();
        return "redirect:/login";
    }

    /**
     * @Description 用户注销
     * @Date 23:34 2018/9/28
     * @Param
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "redirect:/index";
    }

    /**
     * @Description 用户激活
     * @Date 16:24 2018/10/11
     * @Param
     * @return
     */
    @GetMapping(value = "/active/{userName}")
    public String active(@PathVariable("userName") String userName){
        User user = userService.findByUserName(userName);
        user.setActiveCode(CommonEnum.ONE.getCode());//设置为激活状态
        userService.activeUser(user);
        return "/activeSuccess";
    }
}
