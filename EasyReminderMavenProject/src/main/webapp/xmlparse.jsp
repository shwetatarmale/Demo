<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parsexml</title>

</head>
<body>
	<link rel="stylesheet" href="css/navigation.css">
	<nav class="navbar">
		<ul>
			<li><a href="login.jsp">Home</a></li>
			<li><a href="registration.jsp">Register</a></li>
			<li><a href="jsonparse.jsp">ParseJson</a></li>
			<li><a href="errordata.jsp">ErrorData</a></li>
			<li><a href="display.jsp">DisplayErrorData </a></li>
			<li><a href="logout">Logout</a></li>


		</ul>
	</nav>
	<form method="post" action="Xmlparsefile">
		<label for="lfname">File Path:</label>
		 <input type="text" id="fname" name="fname">
		<button type="submit" formaction="Xmlparsefile"
			class="btn btn-larger btn-block" />
		Parse File
		</button>
	</form>
</body>
</html>