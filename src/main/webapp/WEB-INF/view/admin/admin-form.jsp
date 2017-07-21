<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/commons/taglib.jsp"%>
<form class="layui-form layui-box" style='padding:25px 30px 20px 0' action="${ctx}/admin/api/admin-add" data-auto="true" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户账号</label>
        <div class="layui-input-block">
        	<c:choose>
        		<c:when test="${empty resp.admin.loginName}">
        			<input type="text" name=loginName value='' required="required" title="请输入用户账号" placeholder="请输入用户账号" class="layui-input">
        		</c:when>
        		<c:otherwise>
        			<input type="text" readonly name="loginName" value='${resp.admin.loginName}' required="required" title="请输入用户账号" placeholder="请输入用户账号" class="layui-input">
        		</c:otherwise>
        	</c:choose>
        </div>
    </div>
	
	<div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="realName" value='${resp.admin.realName}' title="请输入姓名" placeholder="请输入姓名" class="layui-input">
        </div>
    </div>
	
    <div class="layui-form-item">
        <label class="layui-form-label">联系手机</label>
        <div class="layui-input-block">
            <input type="text" name="mobile" value='${resp.admin.mobile}' pattern="^1[3-9][0-9]{9}$" title="请输入联系手机" placeholder="请输入联系手机" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" pattern="^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$" value='${vo.email}' title="请输入联系邮箱" placeholder="请输入联系邮箱" class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label">访问权限组</label>
        <div class="layui-input-block">
        	<c:forEach var="item" items="${resp.roleList}">
        		<c:choose>
        			<c:when test="${item.roleId} == ${resp.admin.roleId}">
        				<input type="radio" checked name="roleId" value="${item.roleId}" title="${item.roleName}">
        			</c:when>
        			<c:otherwise>
        				<input type="radio" name="roleId" value="${item.roleId}" title="${item.roleName}">
        			</c:otherwise>
        		</c:choose>
        	</c:forEach>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户描述</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入用户描述" title="请输入用户描述" class="layui-textarea" name="adminDesc">${resp.admin.adminDesc}</textarea>
        </div>
    </div>
    <div class="layui-form-item text-c">
    	<input type='hidden' value='${resp.admin.id}' name='id'/>
        <button class="layui-btn" type='submit'>保存数据</button>
        <button class="layui-btn layui-btn-danger" type='button' data-close>取消编辑</button>
    </div>

    <!-- <script>window.form.render();</script> -->
</form>
