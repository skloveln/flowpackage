<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="images/icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="css/login/reset.css" />
<link rel="stylesheet" href="css/login/login.css" />
<title>登录页-流量充值后台管理系统-摩尔科技</title>
</head>
<body>
<div class="page">
		<div class="loginwarrp">
			<div class="logo"><!-- 摩尔科技流量 -->开源后台管理系统</div>
			<div class="login_form">
				<form id="loginForm" name="Login" method="post">
					<ul>
						<li class="login-error">
							<div class="error" id="errMsg"></div>
						</li>
						<li class="login-item">
							<span>用户名：</span>
							<input type="text" id="username" name="loginName" placeholder="请输入用户名" class="login_input" autocomplete="off">
						</li>
						<li class="login-item">
							<span>密　码：</span>
							<input type="text" id="password" name="password" placeholder="请输入密码"  onfocus="$(this).attr('type','password');" class="login_input" autocomplete="off">
						</li>
						<!--<li class="login-item verify">
						<span>验证码：</span>
						<input type="text" name="CheckCode" class="login_input verify_input">
						</li>
						<img src="images/verify.png" border="0" class="verifyimg" />
						<div class="clearfix"></div> -->
						<li class="login-sub">
							<input type="submit" name="Submit" value="登录" />
							<input type="reset" name="Reset" value="重置" />
						</li>
					</ul>
				</form>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/view/commons/jslib.jsp" %>
	<script type="text/javascript" src="${ctx}/staticlib/plugs/canvas-particle/canvas-particle.js"></script>
	<script type="text/javascript" src="${ctx}/staticlib/module/login/login.js"></script>
	<script type="text/javascript">
	//layui.use('adminplugs', function(){
		$(function(){
			var config = {
				vx: 4,
				vy: 4,
				height: 2,
				width: 2,
				count: 100,
				color: "121, 162, 185",
				stroke: "100, 200, 180",
				dist: 6000,
				e_dist: 20000,
				max_conn: 10
			}
			CanvasParticle(config);
		});
		
	</script>
</body>
</html>