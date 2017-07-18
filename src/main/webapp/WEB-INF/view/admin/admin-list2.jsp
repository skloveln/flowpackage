<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont"></i>
		<a href="#" class="maincolor">管理员管理</a>
		<span class="c-999 en">&gt;</span>
		<a href="#" class="maincolor">管理员列表</a>
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="admin-main">
				<div class="layui-field-box layui-form">
					<!-- <div style="float:right; margin:0 15px 10px">
						<button data-modal="/admin/user/add.html" data-title="添加用户" class="layui-btn layui-btn-small"><i class="fa fa-plus"></i> 添加用户
					    </button>
						<button data-update="" data-field="delete" data-action="/admin/user/del.html" class="layui-btn layui-btn-small layui-btn-danger"><i class="fa fa-remove"></i> 删除用户
					    </button>
					</div> -->
					<form class="layui-form layui-form-pane" id="searchForm">
						<div class="layui-form-item">
							<label class="layui-form-label">姓名:</label>
							<div class="layui-input-inline">
								<input type="text" name="loginName" placeholder="根据姓名过滤" class="layui-input">
							</div>
							<label class="layui-form-label">手机号:</label>
							<div class="layui-input-inline">
								<input type="text" name="mobile" placeholder="根据手机号过滤" class="layui-input">
							</div>
							<input type="hidden" value="1" name="pageNumber">
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
							<tr v-for="item in list">
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
							<tr v-if="loaded==true && list.length == 0">
								<td colspan="8" style="text-align: center">暂无数据</td>
							</tr>
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
