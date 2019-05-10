<div class="title" id="comment">
    <h3>评论</h3>
</div>
    <input id = "blogId" type="hidden" name="blogId" value="${(blog.blogId)!}">
    <@shiro.user>
        <div id="respond">
            <form id="comment-form" name="comment-form" action="/comment/save" method="post">
                <div class="comment">
                    <input  type="hidden" name="blogId" value="${(blog.blogId)!}">
                    <div class="comment-box">
                        <textarea placeholder="您的评论或留言" name="content" id="comment-textarea" cols="100%" rows="3" tabindex="3"></textarea>
                        <div class="comment-ctrl">
                            <div class="comment-prompt" style="display: none;"><i class="fa fa-spin fa-circle-o-notch"></i> <span class="comment-prompt-text">评论正在提交中...请稍后</span>
                            </div>
                            <div class="comment-success" style="display: none;"><i class="fa fa-check"></i> <span class="comment-prompt-text">评论提交成功...</span></div>
                            <button type="submit" name="comment-submit" id="comment-submit" tabindex="4">评论</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </@shiro.user>
    <@shiro.guest>
        游客您好，您当前未登录，不能进行评论！<br/>
        <li>请先<a title="登录" href="/login">登录</a>,没有账号？</li>
        <li>去<a title="注册" href="/registerPage">注册</a></li>
    </@shiro.guest>
    <hr>

    <div id="postcomments">
        <ol id="comment_list" class="commentlist">
            <#-- 评论内容-->
        </ol>
    </div>

    <script>
        $("#comment-form").submit(function (envent) {
            if($("#comment-textarea").val() === ''){
                alert("评论内容不能为空！");
                return false;
            }
            envent.preventDefault();
            var form = $(this);
            $.ajax({
                url: form.attr("action"),
                type: "POST",
                data: form.serialize(),
                dataType: "json",
                beforeSend: function () {
                    // alert(1);
                },
                success: function (data) {
                    if(data){
                        // alert("评论成功！");
                        document.location.reload();
                    }

                },
                error: function () {
                    alert("评论失败！");
                },
                complete:function () {
                    //do something
                }
            });
        });

        $(function () {
            var content = "";
            $.ajax({
                type:'GET',
                url:'/comment/findComments',
                data:{blogId:$("#blogId").val()},
                dataType:'json',
                success:function (data) {
                    // console.log(data);
                    var a = data.length;
                    if(data != null || data.length > 0){
                        for(var i = 0;i < data.length;i++){
                            content += " <li class=\"comment-content\">\n" +
                                    "                <span class=\"comment-f\">#"+a+"</span>\n" +
                                    "                <div class=\"comment-main\">\n" +
                                    "                    <p><a class=\"address\" href=\"#\" rel=\"nofollow\">"+data[i].userName+"</a>\n" +
                                    "                        <span class=\"time\">(发表于："+data[i].createTime+")</span><br>"+data[i].content+"\n" +
                                    "                    </p>\n" +
                                    "                </div>\n" +
                                    "            </li>";
                            a--;
                        }
                        $("#comment_list").append(content);
                    }
                    if(data.length === 0){
                        //无评论
                        $("#comment_list").html("<li>当前无任何评论</li>");
                    }

                }
            });
        });
    </script>