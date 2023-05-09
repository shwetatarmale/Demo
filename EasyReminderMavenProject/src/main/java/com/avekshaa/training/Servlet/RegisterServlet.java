package com.avekshaa.training.Servlet;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.model.IModel;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.avekshaa.traning.mail.SendMailService;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String mobileno = request.getParameter("mobileno");

		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root",
					"shweta@12345");
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, address);
			ps.setString(6, mobileno);
			int i = ps.executeUpdate();
			if (i > 0) {
				response.sendRedirect("thankyou.jsp");
				SendMailService sr = new SendMailService();
				SendMailService.sendRegistrationEmail(request);
				
				return;
			}

			// if (i > 0)
			// out.print ("You are successfully registered...");

		} catch (Exception e2) {
			System.out.println(e2);
		}
		out.close();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve the data from the database and store it in a list
	    List<MyData> messageList = new ArrayList<>();

	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root",
				"shweta@12345")) {
	        String query = "SELECT sender, recipient, subject, body, date FROM messages";
	        try (PreparedStatement stmt = conn.prepareStatement(query)) {
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    String name = rs.getString("name");
	                    String lastname = rs.getString("lastname");
	                    String email = rs.getString("email");
	                    
	                    MyData message = new MyData(name, lastname, email);
	                    messageList.add(message);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        // Handle any exceptions
	    }

	    // Create a data model and add the message list to it
	    Map<String, Object> model = new HashMap<>();
	    model.put("messages", messageList);

	    // Set the content type of the response to HTML
	    response.setContentType("text/html");

	    // Use Thymeleaf to render the template with the data model
	    TemplateEngine engine = new TemplateEngine();
	    ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
	    resolver.setTemplateMode(TemplateMode.HTML);
	    resolver.setPrefix("/templates/");
	    resolver.setSuffix(".html");
	    engine.setTemplateResolver(resolver);

	    try (PrintWriter writer = response.getWriter()) {
	        engine.process("emailcontent", new Context(Locale.getDefault(), model), writer);
	    }
	}
	

}
