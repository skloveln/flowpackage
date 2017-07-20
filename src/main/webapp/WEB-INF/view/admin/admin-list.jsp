<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/view/commons/meta.jsp" %>
<title>管理员列表-流量充值后台管理系统-摩尔科技</title>
</head>
<body>
<%@include file="/WEB-INF/view/commons/header.jsp" %>
<%@include file="/WEB-INF/view/commons/menu.jsp" %>
<%request.setCharacterEncoding("utf-8"); %>  
<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont"></i>
		<a href="#" class="maincolor">管理员管理</a>
		<span class="c-999 en">&gt;</span>
		<a href="${ctx}/admin/admin-list.html" class="maincolor">管理员列表</a>
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload();" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="admin-main">
				<div class="layui-field-box layui-form">
					<form class="layui-form layui-form-pane" id="searchForm">
						<div class="layui-form-item">
							<label class="layui-form-label">姓名:</label>
							<div class="layui-input-inline">
								<input type="text" name="loginName" value="${param.loginName}"  placeholder="根据姓名过滤" class="layui-input">
							</div>
							<label class="layui-form-label">手机号:</label>
							<div class="layui-input-inline">
								<input type="text" name="mobile" value="${param.mobile}"  placeholder="根据手机号过滤" class="layui-input">
							</div>
							<button class="layui-btn" >查询</button>
							<button  class="layui-btn" data-modal="/admin/user/add.html" data-title="添加用户"><i class="fa fa-plus"></i> 添加用户
						    </button>
						</div>
					</form>
					<table class="layui-table" lay-even="" lay-skin="row">
						<thead>
							<tr>
								<th>序号</th>
								<th>账号</th>
								<th>姓名</th>
								<th>手机号</th>
								<th>邮箱</th>
								<th>最后登录</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="table-body">
						</tbody>
					</table>
				</div>
				<div class="admin-table-page" style="float:right; bottom:20;">
					<div id="page"></div>
				</div>
			</div>
		</article>
		<%@include file="/WEB-INF/view/commons/footer.jsp" %>
	</div>
</section>
<%@include file="/WEB-INF/view/commons/jslib.jsp" %>
<script id="main-template"  type="text/html"> 
	{{if rows.length > 0}} 
		{{each rows item}}
			<tr>
				<td>{{item.adminId}}</td>
				<td>{{item.loginName}}</td>
				<td>{{item.realName}}</td>
				<td>{{item.mobile}}</td>
				<td>{{item.email}}</td>
				<td>{{item.lastLoginTime}}</td>
				<td>{{item.availableFlag}}</td>
				<td>
					<a class="layui-btn layui-btn-mini">修改</a>
					<a data-update="1" data-field='delete' data-action='${ctx}/admin/delete' class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
				</td>
			</tr>
		{{/each}} 
	{{else}}
		<tr><td colspan="8" style="text-align: center">暂无数据</td></tr>
	{{/if}}
</script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
 layui.use('adminplugs', function(){
	var url = "${ctx}/admin/api/getAdminRoleList";
	var params = $('#searchForm').serializeObject();
	$.table.show(url, params);
});
</script>
</body>
</html>