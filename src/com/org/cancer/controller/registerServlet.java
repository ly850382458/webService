package com.org.cancer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.cancer.pojo.Student;
import com.org.cancer.service.IStudentService;
import com.org.cancer.service.impl.StudentServiceImpl;


@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		String numStr = request.getParameter("num");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String ageStr = request.getParameter("age");
		String scoreStr = request.getParameter("score");
		int num = Integer.valueOf(numStr);
		int age = Integer.valueOf(ageStr);
		Double score = Double.valueOf(scoreStr);
		Student student = new Student(num,name,age,score);
		student.setPassword(password);
		IStudentService studentService = new StudentServiceImpl();
		try {
			if(studentService.addStudent(student)) {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("messgae", "注册失败");
				response.sendRedirect(request.getContextPath()+"/register.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
