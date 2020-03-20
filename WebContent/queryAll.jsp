<%@page import="com.org.cancer.pojo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>密码</th>
			<th>年龄</th>
			<th>分数</th>
		</tr>
		<%
			List<Student> students =(List<Student>)request.getAttribute("list");
			for(Student  student : students){
		%>
		<tr>
			<td><%=student.getNum() %></td>
			<td><%=student.getName() %></td>
			<td><%=student.getPassword() %></td>
			<td><%=student.getAge() %></td>
			<td><%=student.getScore() %></td>
		</tr>
		<% 		
			}
		%>
		
	
	</table>
</body>
</html>