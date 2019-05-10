<div class="fixed">
    <div class="widget widget-tabs">
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active">
                <a href="#notice" aria-controls="notice" role="tab" data-toggle="tab">统计信息</a>
            </li>
            <li role="presentation">
                <a href="#contact" aria-controls="contact" role="tab" data-toggle="tab">联系站长</a>
            </li>
        </ul>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane contact active" id="notice">
                <h2>
                    博客总数: ${total!}篇
                </h2>
                <h2>
                    总访问量:<span id="sitetime">${num!} </span></h2>
            </div>
            <div role="tabpanel" class="tab-pane contact" id="contact">
                <h2>
                    QQ:<span rel="nofollow" data-toggle="tooltip" data-placement="bottom" >1695540137</span>
                </h2>
                <h2>
                    Email:<span data-toggle="tooltip" rel="nofollow"  data-placement="bottom" >devilyang123@163.com</span></h2>
            </div>
        </div>
    </div>
    <div class="widget widget_search">
        <form class="navbar-form" action="/Search" method="post">
            <div class="input-group">
                <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字"
                       maxlength="15" autocomplete="off">
                <span class="input-group-btn">
		                    <button id="search" class="btn btn-default btn-search" name="search" type="button">搜索</button>
                </span>
            </div>
        </form>
    </div>
</div>
<script>
    $(function () {
        $("#search").click(function () {
            alert("才几篇文章，瞎搜~");
            return false;
        });
    });
</script>