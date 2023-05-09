package com.avekshaa.training.Servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailContentThyLeafe
 */
@WebServlet("/EmailContentThyLeafe")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<MyData> messages = new ArrayList<>();
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root",
						"shweta@12345");
				 String query = "select * from  register";
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery(query);
				
		        while (rs.next()) {
		        	MyData message = new MyData(rs.getString("name"), rs.getString("lastname"), rs.getString("email"));
		            messages.add(message);
		        }
		        con.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    // Pass the data to the Thymeleaf template for rendering
		    request.setAttribute("messages", messages);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("emailcontent.html");
		    dispatcher.forward(request, response);
	}

	

}
