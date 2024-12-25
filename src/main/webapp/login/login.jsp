<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<title>晋中互联网学院，欢迎登录</title>
	 <link rel="icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/webbase.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/back/css/pages-shoplogin.css" />
</head>

<body>
	<div class="login-box">
		<!--head-->
		<div class="py-container logoArea">
			<a href="" class="logo"><img src="<%=request.getContextPath() %>/back/img/_/logo1.png" alt="" style="width: 140px;"></a>
		</div>
		<!--loginArea-->
		<div class="loginArea">
			<div class="login ">
				<div class="py-container">
			 <div class="loginform">
					<ul class="sui-nav nav-tabs tab-wraped">
						<li>
							<a href="#index" data-toggle="tab">
								<h3>扫描登录</h3>
							</a>
						</li>
						<li class="active">
							<a href="#profile" data-toggle="tab">
								<h3>账户登录</h3>
							</a>
						</li>
					</ul>
					<div class="tab-content tab-wraped">
						<div id="index" class="tab-pane">
							<p>二维码登录，暂为官网二维码</p>
							<img src="img/wx_cz.jpg" />
						</div>
						<div id="profile" class="tab-pane  active">
							<form action="<%=request.getContextPath() %>/LoginServlet" method="post" class="sui-form">

								<input type="hidden" name="requestMethod" value="doLogin">

								<div class="input-prepend"><span class="add-on loginname"></span>
									<input id="prependedInput"  name="username" type="text" placeholder="邮箱/用户名/手机号" class="span2 input-xfat">
								</div>
								<div class="input-prepend"><span class="add-on loginpwd"></span>
									<input id="prependedInput"  name="passwordHash" type="password" placeholder="请输入密码" class="span2 input-xfat">
								</div>
								<div class="setting">
									<label class="checkbox inline"><input name="m1" type="checkbox" value="2" checked="">自动登录</label>
									<span class="forget">忘记密码？</span>
								</div>
								<div class="logined">
									<input type="submit" class="sui-btn btn-block btn-xlarge btn-danger">
									<!-- <a class="sui-btn btn-block btn-xlarge btn-danger" href="admin/index.html" target="_blank">登&nbsp;&nbsp;录</a> -->
									
								</div>
							</form>
							<div class="otherlogin">
								<div class="types">
									<ul>
										<li><img src="<%=request.getContextPath() %>/back/img/qq.png" width="35px" height="35px" /></li>
										<li><img src="<%=request.getContextPath() %>/back/img/sina.png" /></li>
										<li><img src="<%=request.getContextPath() %>/back/img/ali.png" /></li>
										<li><img src="<%=request.getContextPath() %>/back/img/weixin.png" /></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

</div>
			</div>
		</div>
		<!--foot-->
		<div class="py-container copyright">
			<div class="address">地址：中原工学院 邮编：030600 电话：400-618-4000 传真：010-82935100</div>
			<div class="beian">京ICP备08001421号京公网安备110108007702
			</div>
		</div>
	</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/plugins/jquery.easing/jquery.easing.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/plugins/jquery-placeholder/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/back/js/pages/shoplogin.js"></script>
</body>

</html>