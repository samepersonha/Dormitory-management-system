package com.qut.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbcpUtils {
	
	private static BasicDataSource ds;
	
	static {
		
		try {
			Properties p = new Properties();
			InputStream in = ClassLoader.getSystemResourceAsStream("com/qut/utils/dbinfo1.properties");
			p.load(in);
			
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			int initialSize = Integer.parseInt(p.getProperty("initialSize"));
			int maxTotal = Integer.parseInt(p.getProperty("maxTotal"));
			int minIdle = Integer.parseInt(p.getProperty("minIdle"));
			int maxWaitMillis = Integer.parseInt(p.getProperty("maxWaitMillis"));
			
			ds = new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(initialSize);
			ds.setMaxTotal(maxTotal);
			ds.setMinIdle(minIdle);
			ds.setMaxWaitMillis(maxWaitMillis);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getCon() throws SQLException {
		return ds.getConnection();
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(DbcpUtils.getCon());
	}
}
