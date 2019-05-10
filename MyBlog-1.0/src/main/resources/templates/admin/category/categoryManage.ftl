<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>分类管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <script src="/static/js/jquery-2.1.4.min.js"></script>
</head>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">分类管理</li>
    </ul>
</div>

<blockquote class="layui-elem-quote">
    <div class="layui-input-inline">
        <input type="text" placeholder="请输入分类名称" autocomplete="off" class="layui-input" id="searchInput">
    </div>
    <button class="layui-btn" id="searchBtn">搜索</button>
    <button class="layui-btn" id="add-btn">添加</button>
    <button class="layui-btn layui-btn-danger" id="batchDelect">批量删除</button>
</blockquote>

<table class="layui-hide" id="myTable"  lay-filter="myTable"></table>

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
            ,url:'/admin/category/findAll'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,height:472
            ,page:true
            ,cols: [[
                 {type: 'checkbox', fixed: 'left'}
                ,{field:'categoryId', title: '分类ID'}
                ,{field:'name',title: '分类名称'}
                // ,{field:'startDate', title: '创建日期'}
                // ,{field:'endDate', title: '修改日期'}
                ,{title:'操作',fixed: 'right'}
            ]]
        });

        //添加住房信息按钮点击事件
        $('#add-btn').on('click', function(){
            var index = layer.open({
                type: 2,
                title:"添加分类",
                area: ['900px', '500px'],
                // shadeClose: true, //点击遮罩关闭
                content: './addPage',
                success:function (layero, index) {
                    setTimeout(function(){
                        layui.layer.tips('点击此处返分类信息列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },100);
                }
            });
            //设置弹出层布满窗口
            // layui.layer.full(index);
        });

        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        });
    });
</script>
</body>
</html>