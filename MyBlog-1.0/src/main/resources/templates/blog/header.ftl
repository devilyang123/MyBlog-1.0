<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="header-topbar hidden-xs link-border">
                <ul class="site-nav topmenu">
                    <@shiro.user>
                            <li><a>欢迎您，<@shiro.principal/></a></li>
                            <li><a title="注销" href="/logout">注销</a></li>
                    </@shiro.user>
                    <li><a href="https://blog.csdn.net/u012430402" target="_blank">CSDN</a></li>
                    <li><a href="https://github.com/devilyang123"  target="_blank">GitHub</a></li>
                </ul>
                学习笔记
            </div>
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#header-navbar" aria-expanded="false"><span class="sr-only"></span> <span
                            class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
                    <h1 class="logo hvr-bounce-in"><a href="/index" title="笑笑的博客"><span>笑笑的博客</span></a></h1>
                </div>
                <div class="collapse navbar-collapse" id="header-navbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a title="首页" href="/index">首页</a></li>
                        <li><a title="文章列表" href="/blog/list">文章列表</a></li>
                         <@shiro.hasRole name="admin">
                                <li><a title="后台管理" href="/admin/index">后台管理</a></li>
                         </@shiro.hasRole>
                        <@shiro.guest>
                            <li><a title="登录" href="/login">登录</a></li>
                            <li><a title="注册" href="/registerPage">注册</a></li>
                        </@shiro.guest>
                        <@shiro.hasRole name="admin">
                            <li><a title="写博客" href="/blog/writeBlog">写博客</a></li>
                        </@shiro.hasRole>

                    </ul>
                </div>
            </div>
        </div>
    </nav>
</header>

