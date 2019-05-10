<div class="widget widget_hot">
    <h3>热门文章</h3>
    <ul id="hotBlog">
      <#-- 文章列表 -->
    </ul>
</div>
<script>
    $(function () {
        var content = "";
        $.ajax({
            type:"GET",
            url:"/blog/findHotBlog",
            dataType:"json",
            success:function (data) {
                // console.log(data);
                if(data.code === 200){
                    for(var i = 0; i < data.data.length; i++){
                        content += " <li>\n" +
                                "            <a title=\""+data.data[i].title+"\" href=\"/blog/getBlogById/"+data.data[i].blogId+"\">\n" +
                                "                        <span class=\"thumbnail\">\n" +
                                "                            <img alt='正在加载图片，长时间未显示请刷新！' class=\"thumb\"" +
                                "               src=\""+URL_PREFIX+data.data[i].imgUrl+"\"  style=\"display: block;\">\n" +
                                "\t\t\t            </span>\n" +
                                "                <span class=\"text\" style='word-break: break-all;'>"+data.data[i].title+"</span>\n" +
                                "                <span class=\"muted\"><i class=\"glyphicon glyphicon-time\"></i> "+data.data[i].createTime+"</span>\n" +
                                "    <br>        <span class=\"muted\"><i class=\"glyphicon glyphicon-eye-open\"></i> "+data.data[i].readNum+"</span>\n" +
                                "            </a>\n" +
                                "        </li>";
                    }
                    // console.log(content);
                    $("#hotBlog").append(content);
                }
                if(data.code === 9999){
                   //无数据
                }
            }
        });
    });
</script>