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
    <link rel="stylesheet" href="/static/kindeditor/themes/simple/simple.css"/>
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/style.css">
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/font-awesome.min.css">
    <link rel="shortcut icon" href="/static/images/favicon.png">
</head>
<body class="user-select">
<#-- 引入header -->
	<#include "./header.ftl">

<div class="container">
    <h1>写博客</h1>
    <br>
    <form action="/blog/saveBlog" method="post" id="saveBlogForm">

        <div class="form-group">
            <label for="title">标题</label>
            <input type="text" class="form-control" id="title" placeholder="标题" name="title">
        </div>

        <div class="form-group">
            <label for="categoryId">分类</label>
            <select class="form-control" id="category" name="categoryId">
                <option value="">请选择</option>
            </select>
        </div>

        <div class="form-group">
            <label for="summary">摘要</label>
            <textarea id="summary" style="width: 100%;height:100px;resize: none;"
                      name="summary_"></textarea>
        </div>

        <div class="form-group">
            <label>图片</label>
            <input type="file" name="imgFile">
        </div>

        <div class="form-group">
            <label for="editor">内容</label>
            <textarea id="editor" style="width: 100%;height: 800px;" name="content"></textarea>
        </div>

        <button type="button" id="formSubmit" class="btn btn-success">发布</button>
    <#--<button type="button" class="btn btn-success" id="save">保存</button>-->
    <#--<button type="button" class="btn btn-info" >发布</button>-->
    <#--<a href="/index"><button type="button" class="btn btn-info" >首页</button></a>-->
    </form>
</div>

<#-- 引入header -->
	<#include "./footer.ftl">

<script src="/static/js/jquery-2.1.4.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<script charset="utf-8" src="/static/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="/static/kindeditor/lang/zh-CN.js"></script>
<script>
    KindEditor.ready(function (K) {
        window.editor = K.create('#editor', {
            // width : '1140',
            // height: '600px',
            resizeType: 0,
            allowPreviewEmoticons: false,
            allowImageRemote: false,
            allowImageUpload: true,//允许上传图片
            // fillDescAfterUploadImage:true,//上传成功后切换到图片编辑标签
            // allowFileManager:true, //允许对上传图片进行管理
            themeType: 'simple',
            uploadJson: "/upload",
            afterUpload: function (data) {
                // var temp = "<img src='"+data+"'>";
                // $(".ke-content").append(temp);
                this.sync();
            },
            afterCreate: function () {  //要取值设置这里 这个函数就是同步KindEditor的值到textarea文本框
                this.sync();
            },
            afterBlur: function () {
                this.sync();
            },//将编辑器内容同步到文本域

            items: [
                'fontname', 'fontsize', 'code',
                '|', 'forecolor',
                'hilitecolor', 'bold',
                'italic', 'underline',
                'removeformat', '|',
                'justifyleft', 'justifycenter',
                'justifyright', 'insertorderedlist',
                'insertunorderedlist', '|', 'fullscreen',
                'link', '|', 'image']
        });
    });
</script>
<script>
    $(function () {
        var category = "";
        $.ajax({
            type: "GET",
            url: "/category/findAll",
            dataType: "json",
            async: true,
            success: function (data) {
                // console.log(data);
                if (data != null) {
                    for (var i = 0; i < data.length; i++) {
                        category += "<option value='" + data[i].categoryId + "'>" + data[i].name + "</option>";
                    }
                    // console.log(category);
                    $("#category").append(category);
                } else {
                    alert("当前没有分类,请去添加");
                }
            },
            error: function () {
                alert("获取分类列表失败");
            }
        });
    });
    $("#formSubmit").click(function () {
        // alert(1);
        var form = new FormData(document.getElementById("saveBlogForm"));
        $.ajax({
            url: "/blog/saveBlog",
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
                if(data){
                    alert("发布成功");
                    window.location.href = "/index";
                }else {
                    alert("发布失败");
                }

            },
            error: function (e) {
                alert("服务器异常");
                // window.clearInterval(timer);
            }
        });
    });
    // $("#saveBlogForm").submit(function (envent) {
    //     envent.preventDefault();
    //     var form = $(this);
    //     $.ajax({
    //         url: form.attr("action"),
    //         type: "POST",
    //         data: form.serialize(),
    //         // contentType:"multipart/form-data",
    //         dataType: "json",
    //         beforeSend: function () {
    //            // alert(1);
    //         },
    //         success: function (data) {
    //             alert("保存文章成功！");
    //             // $("#article").html(data);
    //         },
    //         error: function () {
    //             alert("保存文章失败！")
    //         },
    //         complete:function () {
    //             // $("#ajax-loader").hide();
    //         }
    //     });
    // });
</script>
<script src="/static/js/jquery-2.1.4.min.js"></script>
<script src="/static/js/nprogress.js"></script>
<script src="/static/js/jquery.lazyload.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/js/scripts.js"></script>
</body>
</html>