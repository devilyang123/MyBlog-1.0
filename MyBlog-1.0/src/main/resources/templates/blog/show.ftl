<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>博客详情</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/style.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/font-awesome.min.css">
    <link rel="shortcut icon" href="/static/images/favicon.png">
    <script src="/static/js/jquery-2.1.4.min.js"></script>
    <script src="/static/js/nprogress.js"></script>
</head>
<body class="user-select single">
<#-- 引入header -->
	<#include "./header.ftl">

<section class="container">
    <div class="content-wrap">
        <div class="content">
            <header class="article-header">
                <h1 class="article-title">${(blog.title)!}</h1>
                <div class="article-meta">
                    <span class="item article-meta-time">
                        <time class="time" data-toggle="tooltip" data-placement="bottom" title="发布时间">
                            <i class="glyphicon glyphicon-time"></i> ${(blog.createTime)!}</time>
                    </span>
                    <span class="item article-meta-views" data-toggle="tooltip" data-placement="bottom" title="访问量">
                            <i class="glyphicon glyphicon-eye-open"></i> ${(blog.readNum)!}
                    </span>
                    <span class="item article-meta-comment" data-toggle="tooltip" data-placement="bottom" title="评论数">
                            <i class="glyphicon glyphicon-comment"></i> ${(blog.comments)!}
                    </span>
                    <@shiro.hasRole name="admin">
                        <span><a href="/blog/editBlog/${(blog.blogId)!}" style="text-decoration: none;">编辑</a></span>
                    </@shiro.hasRole>
                </div>
            </header>
        <#--
             -moz-user-select:none; /* Firefox私有属性 */
             -webkit-user-select:none; /* WebKit内核私有属性 */
             -ms-user-select:none; /* IE私有属性(IE10及以后) */
             -khtml-user-select:none; /* KHTML内核私有属性 */
             -o-user-select:none; /* Opera私有属性 */
             user-select:none; /* CSS3属性 */
        -->
        <#-- 解决内容不可复制 -->
            <article class="article-content"
                     style="user-select: text;-moz-user-select:text;-webkit-user-select:text;cursor: text;">
            ${(blog.content)!}
            </article>
            <hr>
        <#--<div class="article-tags">标签：-->
        <#--<a href="#list/2/" rel="tag">DTcms博客</a>-->
        <#--<a href="#list/3/" rel="tag">木庄网络博客</a>-->
        <#--<a href="#list/4/" rel="tag">独立博客</a>-->
        <#--<a href="#list/5/" rel="tag">修复优化</a>-->
        <#--</div>-->
        <#--<div class="relates">-->
        <#--<div class="title">-->
        <#--<h3>相关推荐</h3>-->
        <#--</div>-->
        <#--<ul>-->
        <#--<li><a href="#" title="">用DTcms做一个独立博客网站（响应式模板）-MZ-NetBlog主题</a></li>-->
        <#--<li><a href="#" title="">用DTcms做一个独立博客网站（响应式模板）-MZ-NetBlog主题</a></li>-->
        <#--<li><a href="#" title="">用DTcms做一个独立博客网站（响应式模板）-MZ-NetBlog主题</a></li>-->
        <#--<li><a href="#" title="">用DTcms做一个独立博客网站（响应式模板）-MZ-NetBlog主题</a></li>-->
        <#--<li><a href="#" title="">用DTcms做一个独立博客网站（响应式模板）-MZ-NetBlog主题</a></li>-->
        <#--<li><a href="#" title="">用DTcms做一个独立博客网站（响应式模板）-MZ-NetBlog主题</a></li>-->
        <#--<li><a href="#" title="">用DTcms做一个独立博客网站（响应式模板）-MZ-NetBlog主题</a></li>-->
        <#--<li><a href="#" title="">用DTcms做一个独立博客网站（响应式模板）-MZ-NetBlog主题</a></li>-->
        <#--</ul>-->
        <#--</div>-->

        <#-- 引入模块-->
                <#include "./comments.ftl">

        </div>
    </div>
    <aside class="sidebar">

    <#-- 引入模块-->
            <#include "./infoAndSearch.ftl">

    <#-- 引入模块-->
            <#include "./newCommentBlog.ftl">

    </aside>

</section>
<#-- 引入header -->
    <#include "./footer.ftl">
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/js/jquery.ias.js"></script>
<script src="/static/js/jquery.lazyload.min.js"></script>
<script src="/static/js/scripts.js"></script>
</body>
</html>
