<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加分类</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layui/css/layui.css"  media="all">
</head>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">分类信息表单</li>
    </ul>
</div>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">
            <span style="color: red;">*</span>
            分类名称
        </label>
        <div class="layui-input-inline">
            <input  lay-verify="required" autocomplete="off" class="layui-input categoryName" name="name" type="text">
        </div>

    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-sm"  lay-submit id="categoryForm" lay-filter="categoryForm">添加</button>
            <button class="layui-btn layui-btn-sm layui-btn-primary" type="reset" id="goBack">取消</button>
        </div>
    </div>
</form>


<script src="/static/layui/layui.js"</script>
<script src="/static/js/jquery-2.1.4.min.js"></script>
<script>
    layui.use(['jquery','table','layer','form'], function(){
        var $ = layui.jquery
                ,layer = layui.layer
                ,form = layui.form;

        //表单提交
        form.on("submit(categoryForm)",function(data){
            var index1 = layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            var index2 = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            // console.log(JSON.stringify(data.field));
            var category = new Object();
            category['name'] = $(".categoryName").val();
            // console.log(category);
            $.ajax({
                type:"POST",
                url:"/admin/category/save",
                data:category,
                dataType:"json",
                success: function(data) {
                    if(data){
                        layer.close(index1);
                        parent.layer.close(index2);           //再执行关闭
                        parent.layer.msg('添加成功',{time:2000});
                        parent.layui.table.reload('myTable',{page:{curr:1}});
                        // parent.location.reload();          //刷新父页面
                    }else{
                        layer.close(index1);
                        parent.layer.close(index2);           //再执行关闭
                        parent.layer.msg('添加失败',{time:2000});
                        parent.layui.table.reload('myTable',{page:{curr:1}});
                    }
                },
                error:function () {
                    layer.close(index1);
                    parent.layer.close(index2);     //再执行关闭
                    parent.layer.msg('服务器异常',{time:2000});
                }
            });
            return false;
        });
    });
</script>

</body>
</html>