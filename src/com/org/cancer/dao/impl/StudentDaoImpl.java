package com.org.cancer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.cancer.dao.IStudentDao;
import com.org.cancer.pojo.Student;
import com.org.cancer.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	Student student = null;
	Connection conn = null ;
	Statement stmt = null ;
	PreparedStatement pstmt = null;
	ResultSet rs = null ;

	@Override
	public Student queryStudent(String name, String password) throws SQLException { 
		String sql = "select * from student where name=? and password=?";
		Object[] params = { student.getName(), student.getPassword() };
		rs= JdbcUtil.queryByParams(sql, params);
		if(rs.next()) {
			student.setId(rs.getInt("id"));
			student.setNum(rs.getInt("num"));
			student.setName(rs.getString("name"));
			student.setPassword(rs.getString("password"));
			student.setAge(rs.getInt("age"));
			student.setScore(rs.getDouble("score"));
		}
		JdbcUtil.close(conn, pstmt, rs);
		
		return student;
	}

	@Override
	public boolean addStudent(Student student) throws Exception {
		String sql = "insert into student(num,password,name,age,score) values(?,?,?,?,?)";
		Object[] params = {student.getNum(),student.getPassword(),student.getName(),student.getAge(),student.getScore()};
		boolean bl= JdbcUtil.excute(sql, params);
		JdbcUtil.close(conn, stmt, rs);
		return bl;
	}

	@Override
	public List<Student> queryAllStudent() throws SQLException {
		
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		rs = JdbcUtil.queryByParams(sql, null);
		while(rs.next()) {
			student = new Student();
			student.setId(rs.getInt("id"));
			student.setNum(rs.getInt("num"));
			student.setName(rs.getString("name"));
			student.setPassword(rs.getString("password"));
			student.setAge(rs.getInt("age"));
			student.setScore(rs.getDouble("score"));
			list.add(student);
		}
		JdbcUtil.close(conn, pstmt, rs);
		return list;
	}

}
