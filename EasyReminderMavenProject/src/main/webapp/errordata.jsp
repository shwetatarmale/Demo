<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <link rel="stylesheet" href="css/navigation.css">
<body>
<nav class="navbar">
		<ul>
			<li><a href="login.jsp">Home</a></li>
			<li><a href="xmlparse.jsp">ParseXml</a></li>
			<li><a href="jsonparse.jsp">ParseJson</a></li>
			<li><a href="displayerrordata.jsp">DisplayErrorData </a></li>
			<li><a href="login.jsp">Logout</a></li>
			

		</ul>
	</nav>
 <form action="ErrorDataServlet" method="post"> Enter IDTXN:
  <input type="text" name="idtxn" />
  <br />
  <br /> Enter Description:
  <input type="text" name="description" />
  <br />
  <br /> Enter Error Code:
  <input type="text" name="errorcode" />
  <br />
  <br />
  <input type="submit" value="sample" formaction="ErrorDataServlet">
   </form>
</body>
</html>