<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文章管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <script src="/static/js/jquery-2.1.4.min.js"></script>
</head>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">文章管理</li>
    </ul>
</div>

<blockquote class="layui-elem-quote">
    <div class="layui-input-inline">
        <input type="text" placeholder="请输入博客ID" autocomplete="off" class="layui-input" id="searchInput">
    </div>
    <button class="layui-btn" id="searchBtn">搜索</button>
    <#--<button class="layui-btn" id="add-btn">添加</button>-->
    <button class="layui-btn layui-btn-danger" id="batchDelect">批量删除</button>
</blockquote>

<table class="layui-hide" id="myTable"  lay-filter="myTable"></table>


<script type="text/html" id="operatorBtn">
    {{#  if(d.isTop === 0){ }}
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="topBlogBtn">置顶</a>
    {{# } else{ (d.isTop === 1)}}
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="cancelTopBlogBtn">取消置顶</a>
    {{#  } }}

    {{#  if(d.logic === 0){ }}
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="logicDeleteBtn">删除</a>
    {{# } else{ (d.logic === 1)}}
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="recoverBtn">恢复</a>
    {{#  } }}
</script>

<script type="text/html" id="isTopText">
    {{#  if(d.isTop === 0){ }}
        <span>未置顶</span>
    {{# } else{ (d.isTop === 1)}}
        <span style="color: red">已置顶</span>
    {{#  } }}
</script>

<script type="text/html" id="logicText">
    {{#  if(d.logic === 0){ }}
    <span style="color: green;">正常</span>
    {{# } else{ (d.logic === 1)}}
    <span style="color: red;">已删除</span>
    {{#  } }}
</script>

<script src="/static/layui/layui.js"></script>
<script>
    layui.use(['jquery','table','layer','form'], function() {
        var $ = layui.$ //由于layer弹层依赖jQuery，也可以直接得到
                , table = layui.table
                , form = layui.form
                , layer = layui.layer;
        //初始化表格
        table.render({
            elem: '#myTable'
            // ,data:array
            , url: '/admin/blog/findAll'
            , cellMinWidth: 80
            , height: 472
            , page: true
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'blogId', title: '文章ID'}
                , {field: 'title', title: '标题'}
                , {field: 'readNum', title: '阅读量'}
                , {field: 'comments', title: '评论数'}
                , {field: 'isTop', title: '置顶标识',templet:'#isTopText'}
                , {field: 'isTop', title: '逻辑删除标识',templet:'#logicText'}
                , {field: 'categoryName', title: '所属分类'}
                , {field: 'createTime', title: '发布时间'}
                , {field: 'updateTime', title: '修改时间'}
                ,{title:'操作', toolbar: '#operatorBtn', width:180,fixed: 'right'}
            ]]
        });

        //监听房屋信息列表表格右侧
        table.on('tool(myTable)', function(obj){
            // var checkStatus = table.checkStatus(obj.config.id);
            // console.log(obj);
            switch(obj.event){
                case 'topBlogBtn':
                    $.ajax({
                        url:"/admin/blog/topBlog",
                        type:"GET",
                        data:{blogId:obj.data.blogId},
                        dataType:"json",
                        success:function (data) {
                            // console.log(data);
                            if(data.result === 1){
                                layer.msg(data.msg,{time:2000});
                            } else if (data.result === "delete") {
                                layer.msg(data.msg,{time:2000});
                            }else if(data.result){
                                layer.msg(data.msg,{time:2000});
                                table.reload('myTable',{page:{curr:1}});
                            }else {
                                layer.msg(data.msg,{time:2000});
                                table.reload('myTable',{page:{curr:1}});
                            }
                        },
                        error:function () {
                            layer.msg("服务器异常",{time:2000});
                        }
                    });
                    break;
                case 'cancelTopBlogBtn':
                    $.ajax({
                        url:"/admin/blog/cancelTopBlog",
                        type:"GET",
                        data:{blogId:obj.data.blogId},
                        dataType:"json",
                        success:function (data) {
                            // console.log(data);
                            if(data){
                                layer.msg("取消置顶文章成功",{time:2000});
                                table.reload('myTable',{page:{curr:1}});
                            }else {
                                layer.msg("取消置顶文章失败",{time:2000});
                                table.reload('myTable',{page:{curr:1}});
                            }
                        },
                        error:function () {
                            layer.msg("服务器异常",{time:2000});
                        }
                    });
                    break;
                case 'logicDeleteBtn':
                    $.ajax({
                        url:"/admin/blog/logicDeleteBlog",
                        type:"GET",
                        data:{blogId:obj.data.blogId},
                        dataType:"json",
                        success:function (data) {
                            // console.log(data);
                            if(data){
                                layer.msg("删除文章成功",{time:2000});
                                table.reload('myTable',{page:{curr:1}});
                            }else {
                                layer.msg("删除文章失败",{time:2000});
                                table.reload('myTable',{page:{curr:1}});
                            }
                        },
                        error:function () {
                            layer.msg("服务器异常",{time:2000});
                        }
                    });
                    break;
                case 'recoverBtn':
                    $.ajax({
                        url:"/admin/blog/recoverBlog",
                        type:"GET",
                        data:{blogId:obj.data.blogId},
                        dataType:"json",
                        success:function (data) {
                            // console.log(data);
                            if(data){
                                layer.msg("恢复成功",{time:2000});
                                table.reload('myTable',{page:{curr:1}});
                            }else {
                                layer.msg("恢复失败",{time:2000});
                                table.reload('myTable',{page:{curr:1}});
                            }
                        },
                        error:function () {
                            layer.msg("服务器异常",{time:2000});
                        }
                    });
                    break;
            }
        });
    });
</script>

</body>
</html>