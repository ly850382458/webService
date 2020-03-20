package com.org.cancer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	private static final String URl = "jdbc:mysql://localhost:3306/sms?useUnicode=true&characterEncoding=UTF-8";
	private static final String NAME = "root";
	private static final String PASSWORD = "root";
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	//加载驱动
	 static {
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
	 }

	//获取连接
	public static Connection getConnection() throws SQLException {
		if(conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(URl,NAME,PASSWORD);
		}
		return conn;
	}
	//增删改
	public static boolean excute(String sql,Object[] params) throws SQLException {
		int count = 0;
		getConnection();
		pstmt = conn.prepareStatement(sql);
		if(params!=null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		count = pstmt.executeUpdate();
		if(count > 0) {
			return true;
		}else {
			return false;
		}	
	}
	//查询
	public static ResultSet queryByParams(String sql,Object[] params)throws SQLException{
		getConnection();
		pstmt  = conn.prepareStatement(sql);
		if(params != null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		rs = pstmt.executeQuery();
		return  rs ;
	}
	//关闭连接
	public static void close(Connection conn,Statement stmt,ResultSet rs) throws SQLException {
		if(conn != null ) {
			conn.close();
		}
		if(stmt != null ) {
			stmt.close();
		}
		 if(rs!=null ) {
             rs.close();
         }
	}

	

}
