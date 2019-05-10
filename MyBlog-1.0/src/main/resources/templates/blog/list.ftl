<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>笑笑的博客</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/style.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/font-awesome.min.css">
    <link rel="shortcut icon" href="/static/images/favicon.png">
    <script src="/static/js/jquery-2.1.4.min.js"></script>
</head>
<body class="user-select">
<#-- 引入header -->
	<#include "./header.ftl">

<section class="container">

    <div class="content-wrap">
        <div class="content">
            <div class="title">
                <h3>全部文章</h3>
            <#--<div class="more">-->
            <#--<span>排序：</span>-->
            <#--<a href="#">默认</a>-->
            <#--<a href="#">按更新时间</a>-->
            <#--<a href="#">按访问量</a>-->
            <#--</div>-->
            </div>

            <div class="my-article">
            <#-- 文章 -->
            </div>


        <#-- 分页 -->
            <nav class="pagination">
                <div id="Paginator" style="text-align: center">
                    <ul id="pageLimit"></ul>
                </div>
            </nav>
        </div>
    </div>
    <aside class="sidebar">

        <#-- 引入模块-->
        <#include "./infoAndSearch.ftl">

        <#-- 引入模块-->
        <#--<#include "./tag.ftl">-->

        <#-- 引入模块-->
        <#include "./newCommentBlog.ftl">

    </aside>
</section>
    <#-- footer -->
	<#include "./footer.ftl">

<script src="/static/js/nprogress.js"></script>
<script src="/static/js/jquery.lazyload.min.js"></script>
<script src="/static/js/bootstrap-paginator.js"></script>
<script src="/static/js/jquery.ias.js"></script>
<script src="/static/js/myPage.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/js/scripts.js"></script>
</body>
</html>
