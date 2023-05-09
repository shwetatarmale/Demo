package com.avekshaa.traning.xls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.avekshaa.traning.mail.SendMailService;

/**
 * Servlet implementation class SampleDao
 */
@WebServlet("/ErrorDataServlet")
public class ErrorDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String idtxn = request.getParameter("idtxn");
		String description = request.getParameter("description");
		String errorcode = request.getParameter("errorcode");
		

		HttpSession session = request.getSession();
		session.setAttribute("idtxn", idtxn);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useSSL=false", "root",
					"shweta@12345");
			PreparedStatement ps = con.prepareStatement("insert into sampledata values(?,?,?)");
			ps.setString(1, idtxn);
			ps.setString(2, description);
			ps.setString(3, errorcode);
			
			int i = ps.executeUpdate();
			if (i > 0) {
				response.sendRedirect("thankyou.jsp");
				
				return;
			}

			// if (i > 0)
			// out.print ("You are successfully registered...");

		} catch (Exception e2) {
			System.out.println(e2);
		}
		out.close();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useSSL=false", "root", "shweta@12345");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sampledata");

            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("idtxn", rs.getString("idtxn"));
                jsonObject.put("description", rs.getString("description"));
                jsonObject.put("errorcode", rs.getString("errorcode"));
                jsonArray.put(jsonObject);
            }

            con.close();

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(jsonArray);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle errors
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
	}
}
