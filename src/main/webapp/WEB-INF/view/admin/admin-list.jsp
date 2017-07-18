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
								<input type="text" value="${param.name}" name="name" placeholder="根据姓名过滤" class="layui-input">
							</div>
							<label class="layui-form-label">手机号:</label>
							<div class="layui-input-inline">
								<input type="text" value="${param.mobile}" name="mobile" placeholder="根据手机号过滤" class="layui-input">
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
								<td>{{item.id}}</td>
								<td>{{item.loginName}}</td>
								<td>{{item.realName}}</td>
								<td>{{value.mobile}}</td>
								<td>{{value.email}}</td>
								<td>{{item.lastLoginTime}}</td>
								<td>{{value.availableFlag}}</td>
								<td>
									<button v-on:onclick="vmupdate(item)"><i class="fa fa-edit"></i>编辑</button>
									<button v-on:onclick="vmdelete(item.id)" class="layui-btn layui-btn-danger layui-btn-mini"><i class="icon-trash"></i>删除</button>
								</td>
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
<%@include file="/WEB-INF/view/commons/jslib.jsp" %>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
layui.use(['laypage', 'layer'], function(){
	var laypage = layui.laypage;
	
	var vm = new Vue({  
        el: '#table-body',  
        data: {  
        	list: data  
        }, 
        beforeCreate: function() {
        	var reqData = $.extend({"pageNum":curr || 1}, $('#searchForm').serialize());
        	_self.showData(curr, url, reqData);
        },
        methods: {
        	showData: function(curr, url, data) { //列表
	     		$.ajax({
    				url: url,
    				type: "POST",
    				data: data,
    				dataType: "json",
    				success: function(resp) {
    					var respData = eval(resp);
    					vm.list = respData.rows; //给 json 赋值
    					//显示分页
    					laypage({
    						cont: 'page', 
    						pages: respData.totalPages, //通过后台拿到的总页数
    						curr: curr || 1, //当前页
    						jump: function(obj, first) { //触发分页后的回调
    							if(!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
    								_self.showData(obj.curr, url, data);
    							}
    						}
    					});
    				},
    				error: function(er) {
    					layer.msg("服务器出错，请重试！" + console.log(er));
    				}
    			});
        	},
        	vmdelete: function (_id) //删除  
            {  
            	alert("删除");
            },  
            vmupdate: function (item) //更新  
            {  
            	alert("更新");
            }  
        }  
    });
	
	laypage({
		curr:$.getUrlParam('pageNumber'),
		cont: 'page',
		pages: 100,
		prev:false,
		next:false,
		groups: 3,
		skip: true,
		jump: function(obj,first){
			if(obj.curr != $.getUrlParam('pageNumber')) {
				var url = location.href;
				var page = $.getUrlParam('pageNumber');
				if(url.indexOf("?") == -1) {
					if(page) {
						location.href = url+"?pageNumber=1";
					}else if(obj.curr > 1) {
						location.href = url+"?pageNumber="+obj.curr;
					}
				} else {
					if(page) {
						location.href = url.replace("pageNumber="+page,"pageNumber="+obj.curr);
					} else {
						location.href = url.replace("?","?pageNumber="+obj.curr+"&");
					}
				}
			}
		}
	});
});
</script>
</body>
</html>