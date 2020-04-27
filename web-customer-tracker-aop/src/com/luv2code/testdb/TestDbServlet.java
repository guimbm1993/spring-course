package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//setup connection variables
		String user = "guimbm";
		String password = "#guimbm#";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker";
		
		String driver = "com.mysql.jdbc.Driver";
		//get connection to database
		
		try {
			
			PrintWriter out = response.getWriter();
			
			Class.forName(driver);
			Connection myCon = DriverManager.getConnection(jdbcUrl,user,password);
			
			out.println("connected");
			myCon.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
		

	}

}
