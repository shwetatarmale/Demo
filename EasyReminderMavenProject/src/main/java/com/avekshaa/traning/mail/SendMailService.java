package com.avekshaa.traning.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMailService   {
	public static void main(String[] args) {
	    // create a new thread pool with 5 threads
	    ExecutorService executor = Executors.newFixedThreadPool(5);

	    
		// submit multiple tasks to the thread pool to send registration emails
	    // submit multiple tasks to the thread pool
	    HttpServletRequest request = null;
	    executor.submit(() -> {
			try {
				sendRegistrationEmail(request);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	    executor.submit(() -> sendLoginEmail());
	    executor.shutdown();
	  }
	public static void sendLoginEmail() {

		// Recipient's email ID needs to be mentioned.
		String to = "shweta.sitaram@avekshaa.com";

		// Sender's email ID needs to be mentioned
		String from = "shweta.sitaram@avekshaa.com";

		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("shweta.sitaram@avekshaa.com", "tflwlocznjirbveg");

			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Login");

			// Now set the actual message
			message.setText("login successful to our site");

			System.out.println("sending...");
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
			System.out.println("Job executed successfully" + new Date());
			System.out.println("Login email sent by thread: " + Thread.currentThread().getName());
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		 
	}

	public static void sendRegistrationEmail(HttpServletRequest request) throws IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root",
					"shweta@12345");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from  register");
			if (rs.next()) {
				// response.setContentType ("text/html");
				// PrintWriter out = response.getWriter ();
				
				String name = request.getParameter("name");
				String lastname = request.getParameter("lastname");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String address = request.getParameter("address");
				String mobileno = request.getParameter("mobileno");

//	            HttpSession session = request.getSession ();
//	            session.setAttribute ("email", email);
  
				// Recipient's email ID needs to be mentioned.
				String to = email;

				// Sender's email ID needs to be mentioned
				String from = "shweta.sitaram@avekshaa.com";

				// Assuming you are sending email from through gmails smtp
				String host = "smtp.gmail.com";

				// Get system properties
				Properties properties = System.getProperties();

				// Setup mail server
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "465");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.auth", "true");

				// Create a new session with authentication
				Session session2 = Session.getInstance(properties, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication("shweta.sitaram@avekshaa.com", "tflwlocznjirbveg");

					}

				});
				session2.setDebug(true);

				try {
//					String htmlContent = new String(Files.readAllBytes(Paths.get("C:\\AVEKSHAA_PROJECTS\\MAVEN\\ProjectCode\\LoginRegistrationMaven\\WebContent\\emailcontent.html")));
//
//					// Create a MimeMultipart object
//					MimeMultipart multipart = new MimeMultipart("related");
//
//					// Create a text body part
//					MimeBodyPart textPart = new MimeBodyPart();
//					textPart.setText("This is the text content of the email.");
//
//					// Create an HTML body part
//					MimeBodyPart htmlPart = new MimeBodyPart();
//					htmlPart.setContent(htmlContent, "text/html");

//					// Add the text and HTML body parts to the multipart object
//					multipart.addBodyPart(textPart);
//					multipart.addBodyPart(htmlPart);
								
					MimeMessage message = new MimeMessage(session2);
				   message.setHeader("Content-Type", "text/html");
									
					// Set From: header field of the header.
					message.setFrom(new InternetAddress(from));

					// Set To: header field of the header.
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					// Set email subject
					message.setSubject("New User Registration");
					 System.out.println("Registration email sent by thread: " + Thread.currentThread().getName());	
					// String htmlText = ("<table><tr><th>First Name</th><th>Last Name</th><th>Email
					// Address</th><th>Password</th><th>Address</th><th>Mobile
					// Number</th></tr><tr><td>"+name+"</td><td>"+lastname+"</td><td>"+email</td><td>password</td><td>address</td><td>mobileno</td></tr></table>");

					// message.setText("Dear " + name+",\n\nNew User Registration" + "Here are your
					// details:\n" +htmlText+"\n\nThanks,\nYour Admin Team");

					// Set email content
//	                 message.setText("Dear " + name + ",\n\nNew User Registration "
//		                      + "Here are your details:\nUserName: " + name + "\nLastname: " + lastname + "\n"
//		                      + "email: " + email +"\n"+ "Password:"+password+"\n"+"Mobile No:"+mobileno+"\n"+"Address:"+address+"\n\nThanks,\nYour Admin Team");

					String msgContent = "";
					BodyPart messageBodyPart = new MimeBodyPart();
//					String msgContent1 = "Dear " + name + ",\n\nNew User Registration"
//							+ "<table style='text-align: left;position: relative;border-collapse: collapse;background-color: #f6f6f6;'>"
//							+ " <tr style=' background: black;color: white;'>"
//							+ " <th style='border: 1px solid #999;padding: 20px;background: brown;color: white;border-radius: 0;position: sticky;top: 0;padding: 10px;'>UserName</th>"
//							+ " <th style='border: 1px solid #999;padding: 20px;background: brown;color: white;border-radius: 0;position: sticky;top: 0;padding: 10px;'>Lastname</th>"
//							+ " <th style='border: 1px solid #999;padding: 20px;background: brown;color: white;border-radius: 0;position: sticky;top: 0;padding: 10px;'>Email</th>"
//							+ " <th style='border: 1px solid #999;padding: 20px;background: brown;color: white;border-radius: 0;position: sticky;top: 0;padding: 10px;'>Password</th>"
//							+ " <th style='border: 1px solid #999;padding: 20px;background: brown;color: white;border-radius: 0;position: sticky;top: 0;padding: 10px;'>Mobile No</th>"
//							+ "<th style='border: 1px solid #999;padding: 20px;background: brown;color: white;border-radius: 0;position: sticky;top: 0;padding: 10px;'>Address</th>"
//							+ " </tr>"
//
//							+ "<tr style=' background: black;color: white;'>"
//							+ " <td style='border: 1px solid #999;padding: 20px'>  " + name + "</td>"
//							+ " <td style='border: 1px solid #999;padding: 20px'>   " + lastname + "</td>"
//							+ " <td style='border: 1px solid #999;padding: 20px'>   " + email + "</td>"
//							+ " <td style='border: 1px solid #999;padding: 20px'>   " + password + "</td>"
//							+ " <td style='border: 1px solid #999;padding: 20px'>   " + mobileno + "</td>"
//							+ " <td style='border: 1px solid #999;padding: 20px'>   " + address + "</td>" + "</table>"
//							+"\n\nThanks,\nYour Admin Team";
					
					String msgContent1 ="<div style='border:1px solid #DDDDDD;width:800px;font-family:Helvetica,Arial,sans-serif'>"
							+ " <div style='height:60px;width:799px;background:linear-gradient(top,#fff,#ECECEC);background:-webkit-linear-gradient(top,#fff,#ECECEC);background:-moz-linear-gradient(top,#fff,#ECECEC);display:table-cell;vertical-align:middle;text-align:center'>			                   "
						+ "<i><h1 style='color:#800000'>ABC Bank</h1><i>	</i></i></div> "
		               		+ "<div style='background-color:#dadada'>"
		               		+ "<center>"
		               		+ "<table cellpadding='20' cellspacing='0' width=100%>"
		               		+ "<tbody><tr><td><table cellpadding='10' cellspacing='10' height='200px' width='100%' style='background-color:#fff;border-radius:5px'> "
		               		+ "<tbody> <tr><td style='color:#353535'>"
		               		+ "<p>Dear"+ name+ lastname+",</p>"
		               		+ "<p> </p><h3 style='color:green;font-weight:bold'> Account details has been changed in ConfigWatcher</h3>"
		               		+ "<h3 style='font-weight:bold'> Here are the Details </h3> "
		               		+ "<table style='text-align:left'>  "
		               		+ "<tbody><tr>    <td>First Name</td> <td>:" + name +" </td>  </tr>  "
		               		+"<tr>    <td>First Name</td> <td>:" + lastname +" </td>  </tr>"
		               		+ "<tr> <td>Password</td> <td> :" + password + "  </td>  </tr>  "
		               		+ "<tr> <td>Email Id</td> <td> : <a href=mailto "+ email + " rel='noreferrer' target='blank'>"+email+"</a></td> </tr>  "
		               		+ "<tr> <td>Contact Number</td> <td> :" + mobileno + "</td> </tr>  "
		               		+ "<tr> <td>Address</td> <td> :" + address + "</td> </tr>  "
		               		+ "<tr> <td>Company Name:</td>  <td>  Avekshaa Technologies pvt ltd</td>  </tr>"
		               		+ "<tr><th>Role</th>  </tr><tr><td> <ul><li>Software Engineer</li></ul></td></tr> "
		               		+ "<tr> <th colspan='2'>You can login to EasyReminder using below link and update your details</th> </tr>"
		               		+ "<tr><td> <a href='http://localhost:8080/EasyReminder/login.jsp'>EasyReminder</a></td></tr> "
		               		+ "</tbody>"
		               		+ "</table>"
		               		+ "<p>"
		               		+ "</p><br><br>- ER Support Team</td></tr>"
		               		+ "</tbody>"
		               		+ "</table> </td></tr>"
		               		+ "<tr><td style='padding-top:0px'><table cellpadding='10' cellspacing='10' width='100%' style='border-radius:5px'>"
		               		+ "<tbody><tr><td style='color:#4d4d4d;padding-top:0px'>"
		               		+ "<center> Copyright © IndusInd Bank | Powered by Avekshaa Technologies    "
		               		+ "</center><br><b>Confidentiality Note: </b>This message and any attachments may contain legally privileged and/or confidential information.Any unauthorized disclosure, use or dissemination of this e-mail message or its contents, either in whole or in part,is prohibited. If you are not the intended recipient of this e-mail message, kindly notify the sender and then destroy it.   "
		               		+ "</td></tr> "
		               		+ "</tbody>"
		               		+ "</table></td></tr></tbody></table></center></div>"
		               		+ "<div>"
		               		+ "</div>"
		               		+ "<div style='background-color:#dadada;height:100%'>"
		               		+ "</div>"
		               		+ "</div>";
					 System.out.println("Registration email sent by thread: " + Thread.currentThread().getName());	
					messageBodyPart.setContent(msgContent1, "text/html");
					Multipart multipart = new MimeMultipart();
				    multipart.addBodyPart(messageBodyPart);
					message.setContent(multipart);
				
					Transport.send(message);

					 System.out.println("Registration email sent by thread: " + Thread.currentThread().getName());	

					System.out.println("Email sent successfully!");
					System.out.println(" Registration Job executed successfully" + new Date());
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}

			}

			// if (i > 0)
			// out.print ("You are successfully registered...");

		} catch (Exception e2) {
			System.out.println(e2);
		}
		// out.close ();

	}

}
