package com.xiao.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description durid数据源配置类
 * @Auther: 笑笑
 * @Date: 20:21 2018/9/27
 */
@Configuration
public class DruidDataSourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置监控
    //1.配置一个管理后台的servlet
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        Map<String,String> initParams = new HashMap<>();
//        initParams.put("loginUsername","admin");
//        initParams.put("loginPassword","123456");
//        initParams.put("allow","");//默认允许所有访问
//        initParams.put("deny","");
//        bean.setInitParameters(initParams);
//        return bean;
//    }
    //2.配置web监控的filter
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.setFilter(new WebStatFilter());
//        Map<String,String> initParams = new HashMap<>();
//        initParams.put("exclusions","*.css,*.js,/druid/*");
//        bean.setInitParameters(initParams);
//
//        bean.setUrlPatterns(Arrays.asList("/*"));
//        return bean;
//    }
    //浏览器访问http://localhost/druid/index.html1

}
