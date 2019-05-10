package com.xiao.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description shiro配置类
 * @Auther: 笑笑
 * @Date: 19:17 2018/9/24
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private ShiroRealm shiroRealm;

    /**
     * 密码校验规则HashedCredentialsMatcher
     * 这个类是为了对密码进行编码的 ,
     * 防止密码在数据库里明码保存 , 当然在登陆认证的时候 ,
     * 这个类也负责对form里输入的密码进行编码
     * 处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5，会把form表单的密码进行加密
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        return credentialsMatcher;
    }

    /**
     * 配置SecurityManager（可以设置缓存、session管理的方式、realm）
     * @return
     */
    @Bean
    public SecurityManager securityManager(HashedCredentialsMatcher hashedCredentialsMatcher){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置md5的bean
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        //设置Realm
        securityManager.setRealm(shiroRealm);
        return securityManager;
    }

    /**
     * 配置ShiroFilterFactoryBean
     * @param securityManager
     * @return
     */
    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //设置权限过滤器
        Map<String,String> map = new HashMap<>();
//        map.put("/login","anon");
//        map.put("/index","anon");
//        map.put("/","anon");
//        map.put("/checkUser","anon");
//        map.put("/register","anon");
//        map.put("/registerPage","anon");
//        map.put("/active","anon");
//        map.put("/static/**","anon");
//        map.put("/blog/**","anon");
//        map.put("/category/**","anon");
//        map.put("/comment/**","anon");
        map.put("/blog/writeBlog","authc,roles[admin]");
        map.put("/blog/saveBlog","authc,roles[admin]");
        map.put("/admin/**","authc,roles[admin]");
        //设置博客相关模块需要认证和具有admin角色才能访问
        map.put("/**","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return  shiroFilterFactoryBean;
    }

    /**
     * 开启注解
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
