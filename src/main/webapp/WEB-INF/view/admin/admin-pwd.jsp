<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/commons/taglib.jsp"%>
<form class="layui-form layui-box" style='padding:25px 30px 20px 0' action="${ctx}/admin/api/admin-updatepwd" data-auto="true" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户账号</label>
        <div class="layui-input-block">
        	<c:choose>
        		<c:when test="${empty resp.admin.loginName}">
        			<input type="text" name=loginName value='' pattern="\w{4,20}$" required="required" title="账号必须是4-20个字母或数字或下划线" placeholder="账号必须是4-20个字母或数字或下划线" class="layui-input">
        		</c:when>
        		<c:otherwise>
        			<input type="text" readonly name="loginName" value='${resp.admin.loginName}' required="required" title="请输入用户账号" placeholder="请输入用户账号" class="layui-input">
        		</c:otherwise>
        	</c:choose>
        </div>
    </div>
	
	<c:if test="resp.self">
	    <div class="layui-form-item">
	        <label class="layui-form-label">旧的密码</label>
	        <div class="layui-input-block">
	            <input type="password" autofocus name="oldpassword" value='' pattern="^\w{5,20}$" required="required"  title="请输入旧的密码" placeholder="请输入旧的密码" class="layui-input">
	        </div>
	    </div>
	</c:if>
	
    <div class="layui-form-item">
        <label class="layui-form-label">新的密码</label>
        <div class="layui-input-block">
            <input type="password" name="password" value='' pattern="^\w{5,20}$" required="required"  title="密码必须是5-20个字母或数字或下划线" placeholder="密码必须是5-20个字母或数字或下划线" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">重复密码</label>
        <div class="layui-input-block">
            <input type="password" name="repassword" value='' pattern="^\w{5,20}$" required="required" title="重复密码必须和新密码一致" placeholder="请输入重复密码" class="layui-input">
        </div>
    </div>
	
    <div class="layui-form-item text-c">
    	<input type='hidden' value='${resp.admin.adminId}' name='adminId'/>
    	<input type='hidden' value='${resp.self}' name='self'/>
        <button class="layui-btn" type='submit'>保存数据</button>
        <button class="layui-btn layui-btn-danger" type='button' data-close>取消编辑</button>
    </div>
</form>
