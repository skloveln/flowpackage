<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="page" class="com.bupt.test.TestBean"/>
<jsp:setProperty name="user" property="*"/>
<jsp:setProperty property="userName" name="user" param="userName"/>
<jsp:setProperty property="password" name="user" param="password"/>
<jsp:setProperty property="age" name="user" param="age"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 注册成功:<br>
      <hr>
      使用Bean的属性方法<br>
      用户名: <%=user.getUserName()%><br>
      密码: <%=user.getPassword()%><br>
      年龄: <%=user.getAge()%><br>
      <hr>
      使用getProperty<br>
      用户名:<jsp:getProperty name="user" property="userName"/><br>
      密码:  <jsp:getProperty name="user" property="password"/><br>
      年龄:  <jsp:getProperty name="user" property="age"/>
      客户端名称:<%=request.getRemoteAddr() %>
</body>
</html>