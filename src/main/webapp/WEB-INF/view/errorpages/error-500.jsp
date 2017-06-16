<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<%@include file="/WEB-INF/view/commons/meta.jsp" %>
		<title>首页-流量流量充值后台管理系统-摩尔科技</title>
	</head>

	<body>
		<%@include file="/WEB-INF/view/commons/header.jsp" %>
		<%@include file="/WEB-INF/view/commons/menu.jsp" %>

		<section class="Hui-article-box">
			<nav class="breadcrumb"><i class="Hui-iconfont"></i>
				<a href="/" class="maincolor">首页</a> <span class="c-999 en">&gt;</span><span class="c-666">500</span></nav>
			<div class="Hui-article">
				<article class="cl pd-20">
					<section class="page-404 minWP text-c">
						<p class="error-title"><i class="Hui-iconfont va-m" style="font-size:80px">&#xe656;</i><span class="va-m"> 500</span></p>
						<p class="error-description">不好意思，您访问的页面后台异常，请联系开发商~</p>
						<p class="error-info">您可以：
							<a href="javascript:;" onclick="history.go(-1)" class="c-primary">&lt; 返回上一页</a><span class="ml-20">|</span>
							<a href="${ctx}/index.html" class="c-primary ml-20">去首页 &gt;</a>
						</p>
					</section>
				</article>
			</div>
		</section>
		<%@include file="/WEB-INF/view/commons/jslib.jsp" %>
		<!--请在下方写此页面业务相关的脚本-->
		<script type="text/javascript">
		</script>
	</body>
</html>