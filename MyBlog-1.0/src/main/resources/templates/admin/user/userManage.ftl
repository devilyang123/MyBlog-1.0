<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <script src="/static/js/jquery-2.1.4.min.js"></script>
</head>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">用户管理</li>
    </ul>
</div>

<blockquote class="layui-elem-quote">
    <div class="layui-input-inline">
        <input type="text" placeholder="请输入用户名" autocomplete="off" class="layui-input" id="searchInput">
    </div>
    <button class="layui-btn" id="searchBtn">搜索</button>
    <!--<button class="layui-btn" id="add-btn">添加</button>-->
    <button class="layui-btn layui-btn-danger" id="batchDelect">批量删除</button>
</blockquote>

<table class="layui-hide" id="myTable"  lay-filter="myTable"></table>

<script type="text/html" id="operatorBtn">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="topBlogBtn">发送激活邮件</a>
</script>

<script type="text/html" id="isActiveText">
    {{#  if(d.activeCode === 0){ }}
    <span style="color: red">未激活</span>
    {{# } else{ (d.activeCode === 1)}}
    <span style="color: green">已激活</span>
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
            ,url:'/admin/user/findAll'
            ,cellMinWidth: 80
            ,height:472
            ,page:true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'userId', title: '用户ID'}
                ,{field:'userName',title: '用户名'}
                // ,{field:'password',title: '密码'}
                ,{field:'email',title: '邮箱'}
                ,{field:'gender',title: '性别'}
                ,{field:'activeCode',title: '激活状态',templet:'#isActiveText'}
                ,{field:'createTime',title: '注册时间'}
                ,{field:'updateTime',title: '修改时间'}
                ,{title:'操作',toolbar: '#operatorBtn',fixed: 'right'}
            ]]
        });

        //监听房屋信息列表表格右侧
        table.on('tool(myTable)', function(obj){
            // var checkStatus = table.checkStatus(obj.config.id);
            // console.log(obj);
            switch(obj.event){
                case 'topBlogBtn':
                    var index1 = layer.msg('邮件发送中，请稍候',{icon: 16,time:false,shade:0.8});
                    $.ajax({
                        url:"/admin/user/sendActiveEmail",
                        type:"GET",
                        data:{userId:obj.data.userId},
                        dataType:"json",
                        success:function (data) {
                            console.log(data);
                            if(data.result === 1){
                                layer.close(index1);
                                layer.msg("该账号已激活",{time:2000});
                            }else if(data.result){
                                layer.close(index1);
                                layer.msg("邮件发送成功",{time:2000});
                            } else{
                                layer.msg("邮件发送失败",{time:2000});
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