package com.org.cancer.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.cancer.pojo.Student;
import com.org.cancer.service.IStudentService;
import com.org.cancer.service.impl.StudentServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name+"-->"+password);
		
		//获取session
		HttpSession session = request.getSession();
		if(name == null || "".equals(name.trim())) {
			session.setAttribute("messgae", "用户名输入有误");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return ;
		}
		if(password == null || "".equals(password.trim())) {
			session.setAttribute("messgae", "输入密码有误");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return ;
		}
		
		IStudentService studentService = new StudentServiceImpl();
		Student student = null;
		try {
			student = studentService.queryStudent(name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(student);

		if(student == null ) {
			session.setAttribute("messgae", "用户名或密码错误");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			System.out.println("登录有误");
			return;
		}
			session.setAttribute("welcome", name);
			System.out.println("成功登录");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		
		
	}

}
