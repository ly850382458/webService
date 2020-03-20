<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body>
	<%-- <%=request.getSession().getAttribute("message") %> --%>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
		用户名：<input type="text" name='name'><br>
		密码：<input type="password" name='password'><br>
		<input type="submit" value="登录">
	</form>
	<a href="${pageContext.request.contextPath }/ToRegisterServlet">注册</a>
</body>
</html>