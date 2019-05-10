<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <title>用户登录</title>
    <link href="/static/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="shortcut icon" href="/static/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/static/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/static/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/static/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/static/assets/ico/apple-touch-icon-57-precomposed.png">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="/static/js/jquery-2.1.4.min.js"></script>
</head>
<body>
<!-- contact-form -->
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>Login</h1>
            <#--<div class="alert-close"></div>-->
        </div>
        <form action="/checkUser" method="post">
            <li>
                <input type="text" class="text" placeholder="Username" name="username"><a class=" icon user"></a>
            </li>
            <div class="clear"></div>
            <li>
                <input type="password" placeholder="Password" name="password"> <a class="icon lock"></a>
            </li>
            <span style="color: red">${error!}</span>
            <div class="clear"></div>
            <div class="submit">
                <input type="submit" value="Sign in">
                <div class="clear">
                    <a href="/index">首页</a>
                    <a href="/registerPage">注册</a>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
<div class="clear"></div>
<!--- footer --->
<#--<div class="footer">-->
    <#--<p>Copyright &copy; 笑笑学习制作</p>-->
<#--</div>-->

</body>
<#-- 跳出iframe骨架-->
<script language="javascript" type="text/javascript">
    if(top.location !== self.location)top.location=self.location;
</script>
</html>