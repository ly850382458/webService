package com.org.cancer.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.cancer.dao.IStudentDao;
import com.org.cancer.dao.impl.StudentDaoImpl;
import com.org.cancer.pojo.Student;
import com.org.cancer.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	
	 IStudentDao studentDao= new StudentDaoImpl() ;

	@Override
	public Student queryStudent(String name, String password) throws SQLException {
		return studentDao.queryStudent(name, password);
	}

	@Override
	public boolean addStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student);
	}

	@Override
	public List<Student> queryAllStudent() throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.queryAllStudent();
		
	}
	
	

}
