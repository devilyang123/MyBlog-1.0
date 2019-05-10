<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>管理端首页</title>
    <link rel="shortcut icon" href="/static/assets/ico/favicon.png">
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <script src="/static/js/jquery-2.1.4.min.js"></script>
    <style>
        .fontSize{
            font-size: 18px;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><a class="layui-logo" href="/admin/index">笑笑的博客后台管理</a></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
        <#--<li class="layui-nav-item"><a href="/">博客端</a></li>-->
        <#--<li class="layui-nav-item"><a href="">商品管理</a></li>-->
        <#--<li class="layui-nav-item"><a href="">用户</a></li>-->
        <#-- <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
            <dd><a href="">邮件管理</a></dd>
            <dd><a href="">消息管理</a></dd>
            <dd><a href="">授权管理</a></dd>
        </dl>
    </li>-->
        </ul>
    <#--<ul class="layui-nav layui-layout-right">-->
    <#--<li class="layui-nav-item">-->
    <#--<a href="javascript:;">-->
    <#--<img src="http://t.cn/RCzsdCq" class="layui-nav-img">-->
    <#--笑笑-->
    <#--</a>-->
    <#--<dl class="layui-nav-child">-->
    <#--<dd><a href="">基本资料</a></dd>-->
    <#--<dd><a href="">修改密码</a></dd>-->
    <#--</dl>-->
    <#--</li>-->
    <#--<li class="layui-nav-item"><a href="">注销</a></li>-->
    <#--</ul>-->
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree my-menu-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a class="fontSize" href="/admin/index">
                        <i class="layui-icon fontSize">&#xe68e;</i> 后台首页
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a class="fontSize" href="/admin/blog/blogManage" target="_content">
                        <i class="layui-icon fontSize">&#xe705;</i> 文章管理
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a class="fontSize" href="/admin/category/categoryManage" target="_content">
                        <i class="layui-icon fontSize">&#xe63c;</i> 分类管理
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a class="fontSize" href="/admin/user/userManage" target="_content">
                        <i class="layui-icon fontSize">&#xe66f;</i> 用户管理
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a class="fontSize" href="/">
                        <i class="layui-icon fontSize">&#xe857;</i> 去博客端
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="overflow: hidden;">
        <!-- 内容主体区域 -->
        <iframe src="/admin/home" name="_content" width="100%" height="100%" frameborder="0"></iframe>
    <#--<div style="padding: 15px;">内容主体区域</div>-->
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>
<script src="/static/layui/layui.js"></script>
<script>
    layui.use('element', function () {
        var element = layui.element;

    });

    <#--$(function () {-->
        <#--var content = "";-->
        <#--$.get(-->
                <#--"/menu/getAllMenu",-->
                <#--function (data) {-->
                    <#--if (data != null) {-->
                        <#--for (var i = 0; i < data.length; i++) {-->
                            <#--// <li class="layui-nav-item"><a href="" target="_content">首页</a></li>-->
                            <#--content = "<li class='layui-nav-item'>" +-->
                                    <#--"<a style='font-size: 18px;' href='" + data[i].menuUrl + "' target='_content'>" + data[i].menuName + "</a>" +-->
                                    <#--"</li>";-->
                            <#--// console.log(content);-->
                            <#--$(".my-menu-tree").append(content);-->
                        <#--}-->
                    <#--}-->
                <#--}-->
        <#--);-->
    <#--});-->
<#--</script>-->
</body>
</html>