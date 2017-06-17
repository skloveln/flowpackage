<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/login/reset.css" />
<link rel="stylesheet" href="css/login/login.css" />
<script type="text/javascript" src="staticlib/jquery/1.9.1/jquery.min.js"></script>
<title>登录页-流量充值后台管理系统-摩尔科技</title>
</head>
<body>
<div class="page">
		<div class="loginwarrp">
			<div class="logo">管理员登陆</div>
			<div class="login_form">
				<form id="Login" name="Login" method="post" onsubmit="" action="">
					<ul>
						<li class="login-item">
							<span>用户名：</span>
							<input type="text" id="username" name="UserName" class="login_input" autocomplete="off">
							<span id="count-msg" class="error"></span>
						</li>
						<li class="login-item">
							<span>密　码：</span>
							<input type="text" id="password" name="password" onfocus="$(this).attr('type','password');" class="login_input" autocomplete="off">
							<span id="password-msg" class="error"></span>
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
	<script type="text/javascript">
		window.onload = function() {
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
		}
	</script>
    <script type="text/javascript" src="js/login/login.js"></script>
	<script type="text/javascript" src="staticlib/canvas-particle/canvas-particle.js"></script>
</body>
</html>