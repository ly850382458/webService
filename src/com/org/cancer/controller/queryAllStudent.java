package com.org.cancer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.cancer.pojo.Student;
import com.org.cancer.service.IStudentService;
import com.org.cancer.service.impl.StudentServiceImpl;


@WebServlet("/queryAllStudent")
public class queryAllStudent<E> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IStudentService studentService = new StudentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Student> list = (List<Student>) new ArrayList<E>();
		try {
			list = studentService.queryAllStudent();
			request.setAttribute("list", list);
			request.getRequestDispatcher("queryAll.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
