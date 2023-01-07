package com.qut.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {
	
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	
	private static final String url = "jdbc:mysql://localhost/homework2?&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong";

	private static final String user = "root";
	
	private static final String pwd = "123456";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	public static Connection getCon(){
		
		try {
			Connection con;
			con = DriverManager.getConnection(url,user,pwd);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close(Connection con) {
		try {
			if(!con.isClosed())
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(!rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstm) {
		try {
			if(!pstm.isClosed())
				pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(DbUtils.getCon());
	}
	
	
}
