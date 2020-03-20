package com.org.cancer.service;

import java.sql.SQLException;
import java.util.List;

import com.org.cancer.pojo.Student;

public interface IStudentService {
	public Student queryStudent(String name, String password) throws SQLException;
	public List<Student> queryAllStudent()  throws SQLException;
	public boolean addStudent(Student student) throws Exception;

}
