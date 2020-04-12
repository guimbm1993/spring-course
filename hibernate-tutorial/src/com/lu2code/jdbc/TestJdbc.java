package com.lu2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String user = "guimbm";
		String password = "#guimbm#";
		
		try {
		
			System.out.println("Connecting to database " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("connection successful!!");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
