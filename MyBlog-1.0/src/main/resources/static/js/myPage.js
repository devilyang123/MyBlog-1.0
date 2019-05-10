var URL_PREFIX = "http://192.168.231.129/"; //图片URL前缀，为nginx服务器的地址，前提端口号为80

$(function () {
    var size = 6;//每页显示数量
    $.ajax({
        type:'GET',
        url:'/blog/findAll',
        data:{
            page:1,
            size:size
        },
        // async:false,
        dataType:'json',
        success:function (data) {
            // console.log(data);
            var totalPages = data.totalPages;
            var article = '';
            if(data.code === 200){
                for(var i = 0; i < data.data.length; i++){
                    // console.log(data.data);
                    var blogId = data.data[i].blogId;
                    var categoryName = data.data[i].categoryName;
                    var readNum = data.data[i].readNum;
                    var comments = data.data[i].comments;
                    var summary_ = data.data[i].summary_;
                    var createTime = data.data[i].createTime;
                    var title = data.data[i].title;
                    article += "\n" +
                        "\n" +
                        "<article class=\"excerpt excerpt-1\">\n" +
                        "\t<a class=\"focus\" href=\"/blog/getBlogById/"+blogId+"\" title=\""+title+"\" >\n" +
                        "\t\t<img class=\"thumb\" src=\""+URL_PREFIX+data.data[i].imgUrl+"\" alt=\"正在加载图片，长时间未显示请刷新！\"  style=\"display: inline;\">\n" +
                        "\t</a>\n" +
                        "\t<header>\n" +
                        "\t\t<a class=\"cat\" href=\"#\" title=\""+categoryName+"\" >"+categoryName+"<i></i></a>\n" +
                        "\t\t<h2>\n" +
                        "\t\t\t<a href=\"/blog/getBlogById/"+blogId+"\" title=\""+title+"\" >"+title+"</a></h2>\n" +
                        "\t</header>\n" +
                        "\t<p class=\"meta\">\n" +
                        "\t\t<time class=\"time\">\n" +
                        "\t\t\t<i class=\"glyphicon glyphicon-time\"></i>\n" +
                        "\t\t\t"+createTime+"\n" +
                        "\t\t</time>\n" +
                        "\t\t<span class=\"views\"><i class=\"glyphicon glyphicon-eye-open\"></i> "+readNum+"</span>\n" +
                        "\t\t<i class=\"glyphicon glyphicon-comment\"></i> "+comments+"\n" +
                        "\t</p>\n" +
                        "\t<p class=\"note\">"+summary_+"</p>\n" +
                        "</article>";
                    // console.log(article);
                    $(".my-article").html(article);
                }
                //调用分页函数
                pageFn(totalPages,size);
                // console.log(totalPages);
            }
            if(data.code === 9999){
                //无数据
            }
        },
        error:function () {
            console.log("error")
        }
    });
});

//分页函数
function pageFn(totalPages,size){
    $('#pageLimit').bootstrapPaginator({
        currentPage: 1,            //设置默认显示第几页
        totalPages: totalPages,    //总页数
        bootstrapMajorVersion: 3, //设置bootstrap的版本
        numberOfPages:5,           //设置最多显示多少个页码数
        // alignment:"right",        //设置对齐方式
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first": return "首页";
                case "prev": return "上一页";
                case "next": return "下一页";
                case "last": return "末页";
                case "page": return page;
            }
        },
        onPageClicked: function (event, originalEvent, type, page){//给每个页眉绑定一个事件，其实就是ajax请求，其中page变量为当前点击的页上的数字。
            $.ajax({
                url:'/blog/findAll',
                type:'GET',
                data:{
                    page: page,
                    size:size
                },
                dataType:'json',
                success:function (data) {
                    // console.log(data)
                    var article = '';
                    for(var i = 0; i < data.data.length; i++){
                        var blogId = data.data[i].blogId;
                        var categoryName = data.data[i].categoryName;
                        var readNum = data.data[i].readNum;
                        var comments = data.data[i].comments;
                        var summary_ = data.data[i].summary_;
                        var createTime = data.data[i].createTime;
                        var title = data.data[i].title;
                        article += "\n" +
                            "\n" +
                            "<article class=\"excerpt excerpt-1\">\n" +
                            "\t<a class=\"focus\" href=\"/blog/getBlogById/"+blogId+"\" title=\""+title+"\" >\n" +
                            "\t\t<img class=\"thumb\" src=\""+URL_PREFIX+data.data[i].imgUrl+"\" alt=\"正在加载图片，长时间未显示请刷新！\"  style=\"display: inline;\">\n" +
                            "\t</a>\n" +
                            "\t<header>\n" +
                            "\t\t<a class=\"cat\" href=\"#\" title=\""+categoryName+"\" >"+categoryName+"<i></i></a>\n" +
                            "\t\t<h2>\n" +
                            "\t\t\t<a href=\"/blog/getBlogById/"+blogId+"\" title=\""+title+"\"  >"+title+"</a></h2>\n" +
                            "\t</header>\n" +
                            "\t<p class=\"meta\">\n" +
                            "\t\t<time class=\"time\">\n" +
                            "\t\t\t<i class=\"glyphicon glyphicon-time\"></i>\n" +
                            "\t\t\t"+createTime+"\n" +
                            "\t\t</time>\n" +
                            "\t\t<span class=\"views\"><i class=\"glyphicon glyphicon-eye-open\"></i> "+readNum+"</span>\n" +
                            "\t\t<i class=\"glyphicon glyphicon-comment\"></i> "+comments+"\n" +
                            "\t</p>\n" +
                            "\t<p class=\"note\">"+summary_+"</p>\n" +
                            "</article>";
                        // console.log(article);
                        $(".my-article").html(article);
                    }
                },
                error:function () {
                    console.log("error")
                }
            });
        }
    });
}
//查询置顶文章
$(function () {
    $.ajax({
        url:'/blog/findTopBlog',
        type:"GET",
        dataType:"json",
        success:function (data) {
            // console.log(data);
            var content ='';
            if(data != null){
                content = "\n"+
                    "<article class=\"excerpt excerpt-1\">\n" +
                    "\t<a class=\"focus\" href=\"/blog/getBlogById/"+data.blogId+"\" title=\""+data.title+"\" >\n" +
                    "\t\t<img class=\"thumb\" src=\""+URL_PREFIX+data.imgUrl+"\" alt=\"正在加载图片，长时间未显示请刷新！\"  style=\"display: inline;\">\n" +
                    "\t</a>\n" +
                    "\t<header>\n" +
                    "\t\t<a class=\"cat\" href=\"#\" title=\""+data.categoryName+"\" >"+data.categoryName+"<i></i></a>\n" +
                    "\t\t<h2>\n" +
                    "\t\t\t<a href=\"/blog/getBlogById/"+data.blogId+"\" title=\""+data.title+"\" >"+data.title+"</a></h2>\n" +
                    "<span style='color: red;font-size: 16px;'>【TOP】</span>"+
                    "\t</header>\n" +
                    "\t<p class=\"meta\">\n" +
                    "\t\t<time class=\"time\">\n" +
                    "\t\t\t<i class=\"glyphicon glyphicon-time\"></i>\n" +
                    "\t\t\t"+data.createTime+"\n" +
                    "\t\t</time>\n" +
                    "\t\t<span class=\"views\"><i class=\"glyphicon glyphicon-eye-open\"></i> "+data.readNum+"</span>\n" +
                    "\t\t<i class=\"glyphicon glyphicon-comment\"></i> "+data.comments+"\n" +
                    "\t</p>\n" +
                    "\t<p class=\"note\">"+data.summary_+"</p>\n" +
                    "</article>";
                $(".topBlog").append(content);
            }else {
                $(".topBlog").html("");
            }
        }
    });
});