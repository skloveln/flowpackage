<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="images/icon.png" rel="shortcut icon" />
<title>流量充值项目</title>
</head>
<body>
手机流量项目
名字是: ${pageContext.request.queryString}

<a href="<%=response.encodeURL("index.jsp?c=1&wd=Java") %>">Homepage</a>
<%-- <% out.println(request.getSession().getId()); %> --%>
<script language="javascript"type="text/javascript"> 
/* window.location.href="${ctx}/index.htm";  */
</script>
</body>
</html>