<!DOCTYPE html>
<html lang="zh-CN">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>用户注册</title>

        <!-- CSS -->
        <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/static/assets/css/form-elements.css">
        <link rel="stylesheet" href="/static/assets/css/password.css">
        <link rel="stylesheet" href="/static/assets/css/email.css">
        <link rel="stylesheet" href="/static/assets/css/style.css">
        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="/static/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/static/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/static/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/static/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/static/assets/ico/apple-touch-icon-57-precomposed.png">
        <style>

        </style>
    </head>

    <body>

        <!-- Content -->
        <div class="top-content">

            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Welcome</strong>&nbspto xiaoxiao's blog</h1>
                            <div class="description">
                            	<p>
	                            	欢迎注册，欢迎评论
                            	</p>
                            </div>
                            <div class="top-big-link">
                            	<a class="btn btn-link-1 launch-modal" href="#" data-modal-id="modal-register">点击注册</a><br><br>
                            </div>
                                <a class="btn btn-link-1" href="/" >回到首页</a><br><br>
                                <a class="btn btn-link-1" href="/login" >去登陆</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- MODAL -->
        <div class="modal fade" id="modal-register" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
        	<div class="modal-dialog">
        		<div class="modal-content">

        			<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal">
        					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        				</button>
        				<h3 class="modal-title" id="modal-register-label">Sign up now</h3>
        				<p>Fill in the form below to get instant access:</p>
        			</div>

        			<div class="modal-body">

	                    <form role="form" action="/register" method="post" class="registration-form">
	                    	<div class="form-group">
	                    		<label class="sr-only" for="form-first-name">Username</label>
	                        	<input type="text" name="userName" placeholder="Username" class="form-first-name form-control" id="form-first-name">
	                        </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-first-name">Password</label>
                                <input type="password" name="password" placeholder="Password" class="form-first-name form-control" id="form-first-name">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-first-name">Email</label>
                                <input type="email" name="email" placeholder="Email" class="form-first-name form-control" id="form-first-name">
                            </div>
	                        <#--<div class="form-group">-->
	                        	<#--<label class="sr-only" for="form-email">Email</label>-->
	                        	<#--<input type="text" name="form-email" placeholder="Email..." class="form-email form-control" id="form-email">-->
	                        <#--</div>-->
	                        <#--<div class="form-group">-->
	                        	<#--<label class="sr-only" for="form-about-yourself">About yourself</label>-->
	                        	<#--<textarea name="form-about-yourself" placeholder="About yourself..."-->
	                        				<#--class="form-about-yourself form-control" id="form-about-yourself"></textarea>-->
	                        <#--</div>-->
	                        <button type="submit" class="btn">Sign me up!</button>
	                    </form>
        			</div>
        		</div>
        	</div>
        </div>


        <!-- Javascript -->
        <script src="/static/js/jquery-2.1.4.min.js"></script>
        <script src="/static/bootstrap/js/bootstrap.min.js"></script>
        <script src="/static/assets/js/jquery.backstretch.min.js"></script>
        <script src="/static/assets/js/scripts.js"></script>

    </body>

</html>