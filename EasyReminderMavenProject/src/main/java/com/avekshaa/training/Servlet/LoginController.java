package com.avekshaa.training.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avekshaa.traning.mail.SendMailService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String un = request.getParameter("username");
		String pw = request.getParameter("password");

		// Connect to mysql and verify username password

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root",
					"shweta@12345"); // gets a new connection

			PreparedStatement ps = c
					.prepareStatement("select username,password from login where username=? and password=?");
			ps.setString(1, un);
			ps.setString(2, pw);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				response.sendRedirect("success.jsp");
				SendMailService em = new SendMailService();
				SendMailService.sendLoginEmail();

				return;
			}
			response.sendRedirect("error.html");
			return;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
