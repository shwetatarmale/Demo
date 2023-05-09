package com.avekshaa.training.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.avekshaa.training.jsonxmlservices.JsonParse;


@WebServlet("/JsonParserServlet")
public class JsonParserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonParse js = new JsonParse();
		String file=request.getParameter("fname");
		try {
			js.fileReader(file);
			response.sendRedirect("sucessfile.jsp");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//js.jsonpro();
		
		
	}

}
