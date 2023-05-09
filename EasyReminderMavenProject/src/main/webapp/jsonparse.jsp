<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>

</head>
<body>
 <link rel="stylesheet" href="css/navigation.css">
 <nav class="navbar">
		<ul>
	<li><a href="login.jsp">Home</a></li>
	<li><a href="registration.jsp">Register</a></li>
	<li><a href="xmlparse.jsp">ParseXml</a></li>
	<li><a href="errordata.jsp">ErrorData</a></li>
	<li><a href="displayerrordata.jsp">DisplayErrorData </a></li>
	<li><a href="login.jsp">Logout</a></li>
	</ul>
	</nav>
	<form method="post" action="JsonParserServlet">
		<label for="lfname">File Path:</label>
		 <input type="text" id="fname" name="fname">
		<button type="submit" formaction="JsonParserServlet" 
			class="btn btn-larger btn-block" />
		Parse File
		</button>
		
	</form>
</body>
</html>