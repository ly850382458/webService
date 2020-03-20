<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
<body>
	${message }<br>
    <form action="${pageContext.request.contextPath }/registerServlet" method="POST">
	        学号：<input type="text" name="num"/><br>
	        密码：<input type="password" name="password"/><br>
	        姓名：<input type="text" name="name"/><br>
	        年龄：<input type="text" name="age"/><br>
	        成绩：<input type="text" name="score"/><br>
	        <input type="submit" value="注册">
    </form>

</body>
</html>