# 自己练手的博客项目

## 项目技术栈
* SpringBoot 
* SpringBoot-data-jpa
* Shiro 权限框架
* Lombok 代码简化
* Mysql 数据库
* Redis 缓存文章
* Nginx 图片做服务器
* JavaMail(spring-boot-starter-mail) 发送激活邮件
* Freemarker 模板引擎
* SpringBoot 定时任务

## 项目启动
1.需要先安装Mysql、Redis、Nginx、Maven、JDK1.8+
2.按照application-pro.yml 中的注释说明修改配置
3.按照 /static/myPage.js文件中顶部注释修改配置
4.使用blog.sql创建数据库
5.将源码导入IDEA，运行ApplicationEntry.java，访问http://localhost
6.或将项目打成war包后，放入Tomcat(8.5)的webapp目录下，启动Tomcat进行访问
7.后台管理员默认账号：admin， 密码：123

## 说明
本人18年7月份毕业，当时是为了练手+找工作做了该项目，在阿里云服务器跑了两个月左右。
因为当时本人水平有限，项目中有很多不合理的地方，如：想要成为后台管理员，你的账号必
须为admin，这地方在代码里写死了，后期也不打算维护该项目，如果要做，会做一个全新的。

## 学习交友
如有兴趣，欢迎进群交流技术、讨论问题，我也会在群里分享一些好的学习资料。
群号：733899823